package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String submitForm(@ModelAttribute("bookings") Booking bookings) {
        int ticketPrice=350;
        bookings.setTicketPrice(ticketPrice);
        bookings.setPayment("unpaid");
        int totalTicketPrice= bookings.getTicketPrice() * bookings.getNumberOfPersons();
        bookings.setTotalTicketPrice(totalTicketPrice);
        bookingService.saveBooking(bookings);
        return "BookingInfo";
    }
}
