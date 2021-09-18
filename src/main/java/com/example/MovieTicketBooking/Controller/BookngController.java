package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Model.BookingData;
import com.example.MovieTicketBooking.Service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        calculate(bookings);
        Booking booking=bookingService.saveBooking(bookings);
        return "redirect:/checkout";
    }

    private void calculate(Booking bookings) {
        int ticketPrice=350;
        bookings.setTicketPrice(ticketPrice);
        bookings.setPayment("paid");
        int totalTicketPrice= bookings.getTicketPrice() * bookings.getNumberOfPersons();
        bookings.setTotalTicketPrice(totalTicketPrice);
    }
}
