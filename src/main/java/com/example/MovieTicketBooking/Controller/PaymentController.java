package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.Booking;
import com.example.MovieTicketBooking.Model.BookingDTO;
import com.example.MovieTicketBooking.Model.CreatePayment;
import com.example.MovieTicketBooking.Model.CreatePaymentResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@RestController
@RequestMapping
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public String test(HttpServletRequest request, HttpServletResponse response) throws StripeException {
        Gson gson = new Gson();
        response.setContentType("application/json");

        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String dataBody = buffer.toString();

            BookingDTO postBody = gson.fromJson(dataBody,
                    BookingDTO.class);
            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setCurrency("npr")
                    .setAmount(350*100l)
                    .build();
            PaymentIntent intent = PaymentIntent.create(createParams);
            // Send publishable key and PaymentIntent  details to client
            return gson.toJson(new CreatePaymentResponse("pk_test_51JVpymFLT8kGS8MJMfmWTLg3SXim5tsyqSqVxXQWA3C7qFwb9nR0Z6w6ulSSsfaTEuCQTl6zZgMhz51OMQApWhJc0063gL0qWp",
                    intent.getClientSecret()));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
