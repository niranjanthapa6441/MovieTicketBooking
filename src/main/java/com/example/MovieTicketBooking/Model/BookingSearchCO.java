package com.example.MovieTicketBooking.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class BookingSearchCO {
        Optional<Integer> page;
        Optional<Integer> size;
        private String payment;
        private String date;
        private String movieName;
}
