package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class BookingInfoController {
    private BookingService bookingService;

    public BookingInfoController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookingInfo")
    public String saveBooking(Model model){
        Booking bookings= new Booking();
        model.addAttribute("bookings",bookingService.getALlBookings());
        return "BookingInfo";
    }
    @PostMapping("/bookingInfo")
    public String getCheckOut(Model model){
        return "payme";
    }

}
