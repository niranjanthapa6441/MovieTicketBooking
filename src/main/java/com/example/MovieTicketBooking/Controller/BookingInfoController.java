package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Model.BookingData;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class BookingInfoController {
    private BookingService bookingService;

    public BookingInfoController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookingInfo")
    public String saveBooking(Model model){
        //model.addAttribute("bookings",bookingService.findById(bookingID));
        return "BookingInfo";
    }
}
