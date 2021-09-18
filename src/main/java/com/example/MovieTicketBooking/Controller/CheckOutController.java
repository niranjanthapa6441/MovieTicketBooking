package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class CheckOutController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/checkout")
    public String getInfo(@RequestBody Booking booking){
        String ticketID= booking.getTicketID();
        System.out.println(ticketID);
        return "checkout";
    }
}
