package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Customer;
import com.example.MovieTicketBooking.Service.RegisterCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class DisplayCustomerController {
private final RegisterCustomerService registerCustomerService;

    public DisplayCustomerController(RegisterCustomerService registerCustomerService) {
        this.registerCustomerService = registerCustomerService;
    }

    @GetMapping
    public String getAllCustomers(Model model){
        model.addAttribute("customers",registerCustomerService.getALlCustomers());
        return "customers";
    }
}
