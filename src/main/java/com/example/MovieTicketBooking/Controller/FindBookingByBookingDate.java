package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/findBookingByBookingDate")
public class FindBookingByBookingDate {
    private BookingService bookingService;

    public FindBookingByBookingDate(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    private String getBookingsByBookingDate(Model model, @Param("sortedDate") String date){
        System.out.println(date);
        return "findBookingByBookingDate";
    }
}
