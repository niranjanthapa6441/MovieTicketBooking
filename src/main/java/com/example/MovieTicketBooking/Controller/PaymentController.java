package com.example.MovieTicketBooking.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping
    public String showPaymentForm(){
        return "Payme";
    }
    @PostMapping
    public String choosePaymentOption(@RequestParam("paymentOption") String option){
        if (option.equals("offline")){
            return "OfflinePayment";
        }
        else if(option.equals("online")){
         return "OnlinePayments";
        }
    return "Payme";
    }
}
