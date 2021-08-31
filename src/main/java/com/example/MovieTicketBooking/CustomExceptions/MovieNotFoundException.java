package com.example.MovieTicketBooking.CustomExceptions;

public class MovieNotFoundException extends Throwable {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
