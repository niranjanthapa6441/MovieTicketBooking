package com.example.MovieTicketBooking.CustomExceptions;

public class HallNotFoundException extends Throwable  {
    public HallNotFoundException(String message) {
        super(message);
    }
}
