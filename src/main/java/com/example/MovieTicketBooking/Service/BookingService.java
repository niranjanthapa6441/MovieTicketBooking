package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Repository.BookingDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    private final BookingDetailsRepository bookingDetailsRepository;

    public BookingService(BookingDetailsRepository bookingDetailsRepository) {
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    public Booking saveBooking(Booking booking){
        return bookingDetailsRepository.save(booking);
    }
    public Iterable<Booking> getALlBookings(){
        return bookingDetailsRepository.findAll();
    }
    public Optional<Booking> findById(String id) {
        return bookingDetailsRepository.findById(id);
    }
}
