package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Customer;
import com.example.MovieTicketBooking.Model.Role;
import com.example.MovieTicketBooking.Model.Users;
import com.example.MovieTicketBooking.Service.RoleService;
import com.example.MovieTicketBooking.Service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/userRegistration")
public class UserController {
    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping
    public String registerCustomer(Model model){
        Users users= new Users();
        model.addAttribute("usersAdded",users);
        return "UserRegistration";
    }
    @PostMapping
    public String saveCustomer(@ModelAttribute Users users, Model model, RedirectAttributes redirectAttributes){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        userService.saveUser(users);
        model.addAttribute("usersAdded",users);
        return "redirect:/login";
    }
}
