package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookngController {
    private final BookingService bookingService;

    public BookngController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping
    public String saveBooking(Model model){
        Booking bookings= new Booking();
        model.addAttribute("bookings",bookings);
        return "BookTickets";
    }
    @PostMapping
    public String addBooking(@ModelAttribute Booking bookings, Model model) {
        bookingService.saveBooking(bookings);
        model.addAttribute("bookings",bookings);
        return "displayBookingDetails";
    }
}
