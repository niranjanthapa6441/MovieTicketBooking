package com.example.MovieTicketBooking.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentResponse {
    private String clientSecret;
    public CreatePaymentResponse(String pk_test_51JVpymFLT8kGS8MJMfmWTLg3SXim5tsyqSqVxXQWA3C7qFwb9nR0Z6w6ulSSsfaTEuCQTl6zZgMhz51OMQApWhJc0063gL0qWp, String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
