package com.example.MovieTicketBooking.Controller;
import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Model.BookingSearchCO;
import com.example.MovieTicketBooking.Service.DisplayBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/showALlBookings")
public class DisplayBookingController {
    private final DisplayBookingService displayBookingService;

    public DisplayBookingController(DisplayBookingService displayBookingService) {
        this.displayBookingService = displayBookingService;
    }
    @GetMapping
    public String displayALlBookings(Model model){
        Booking booking= new Booking();
        model.addAttribute("bookings",displayBookingService.getALlBookings());
        return "displayBookingDetails";
    }
    @PostMapping
    public ResponseEntity articles(
            BookingSearchCO searchCO){
        return displayBookingService.getPaginatedStudents(searchCO);
    }
}
