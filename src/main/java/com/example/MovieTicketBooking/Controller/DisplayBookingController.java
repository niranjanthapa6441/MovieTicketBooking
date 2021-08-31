package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allBookings")
public class DisplayBookingController {
    private final BookingService bookingService;

    public DisplayBookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    private String getAllBookings(Model mOdel){
        mOdel.addAttribute("bookings",bookingService.getALlBookings());
        return "displayBookingDetails";
    }
}
