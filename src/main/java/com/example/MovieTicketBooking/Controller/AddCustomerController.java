package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Customer;
import com.example.MovieTicketBooking.Service.RegisterCustomerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Register")
public class AddCustomerController {
    RegisterCustomerService registerCustomerService;


    public AddCustomerController(RegisterCustomerService registerCustomerService) {
        this.registerCustomerService = registerCustomerService;
    }

    @GetMapping
    public String registerCustomer(Model model){
        Customer customer= new Customer();
        model.addAttribute("customerAdded",customer);
        return "Registration";
    }
    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttributes){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        registerCustomerService.registerCustomer(customer);
        model.addAttribute("customerAdded",customer);
        return "redirect:/login";
    }

}
