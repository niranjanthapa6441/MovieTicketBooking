package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CheckOutController {
    @Value("${stripe.public.key}")
    private String stripePublicKey;
    @GetMapping("/checkout")
    public String getCheckoutForm(Model model){
        Booking booking= new Booking();
        System.out.println(booking.getAuditorium());
        model.addAttribute("stripePublicKey",stripePublicKey);
        return "checkout";
    }
}
