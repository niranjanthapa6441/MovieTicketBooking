package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Model.BookingDTO;
import com.example.MovieTicketBooking.Model.BookingSearchCO;
import com.example.MovieTicketBooking.Model.Utils;
import com.example.MovieTicketBooking.Repository.BookingDetailsRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DisplayBookingService {
    @Autowired
    private BookingDetailsRepository bookingRepository;
    @Autowired
    private EntityManager entityManager;


    public Iterable<Booking> getALlBookings(){
        return bookingRepository.findAll();
    }
    public ResponseEntity getPaginatedStudents(BookingSearchCO srchCo) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
            Root root = criteriaQuery.from(Booking.class);
            List<Predicate> predicateList = new ArrayList<>();

            if (Strings.isNotBlank(srchCo.getMovieName())) {
                predicateList.add(criteriaBuilder.like(root.get("movieName"), "%" + srchCo.getMovieName() + "%"));
            }
            if (Strings.isNotBlank(srchCo.getDate())) {
                predicateList.add(criteriaBuilder.equal(root.get("date"), Utils.convertStrToDate(srchCo.getDate(),"yyyy-MM-dd")));
            }
            if (!srchCo.getPayment().isEmpty()) {
                predicateList.add(criteriaBuilder.equal(root.get("payment"), srchCo.getPayment()));
            }
            if (srchCo.getPayment() == null || srchCo.getPayment().isEmpty()) {
                getALlBookings();
            }
            List<Order> orderList = new ArrayList<>();
            //ordered by id, you can write your own sorting with entity field names
            orderList.add(criteriaBuilder.asc(root.get("movieName")));

            criteriaQuery.orderBy(orderList);

            Predicate[] predicateArr = new Predicate[predicateList.size()];
            Predicate predicate = criteriaBuilder.and(predicateList.toArray(predicateArr));
            criteriaQuery = criteriaQuery.where(predicate);
            TypedQuery<Booking> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
            List<Booking> resultList = typedQuery.getResultList(); // it may contain large data and some that we do not need too
            List<BookingDTO> dtos = new ArrayList<>(); // so we will convert in data transfer objects with required fields
            resultList.forEach(r -> {
                dtos.add(new BookingDTO(r));
            });
            int pageSize = srchCo.getSize().orElse(10);
            int pageNumber = srchCo.getPage().orElse(1) - 1;
            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "movieName");
            Page<BookingDTO> resultPage = null;

            if (resultList.size() > 0) {
                int from = pageNumber * pageSize;
                int to = from + pageSize;
                if (resultList.size() < to) {
                    to = resultList.size();
                }
                resultPage = new PageImpl<>(dtos.subList(from, to), pageable, dtos.size()); // list is sliced according to page number and size
            } else resultPage = new PageImpl<>(new ArrayList<>(), pageable, 0);

            return ResponseEntity.status(HttpStatus.CREATED).body(resultPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

    }
}