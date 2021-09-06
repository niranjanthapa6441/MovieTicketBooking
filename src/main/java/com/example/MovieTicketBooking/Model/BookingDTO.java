package com.example.MovieTicketBooking.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDTO {

    private String bookingID;
    private String movieName;
    private String date;
    private String time;
    private String hall;
    private int numberOfPersons;
    private String auditorium;
    private String seatNumber;
    private int ticketPrice;
    private int totalTicketPrice;
    private String payment;

    public BookingDTO() {
    }
    public BookingDTO(Booking booking) {
        this.bookingID=booking.getBookingID();
        this.auditorium=booking.getAuditorium();
        this.date = Utils.convertDateToStr(booking.getDate(),"dd/MM/yyyy");
        this.hall=booking.getHall();
        this.movieName=booking.getMovieName();
        this.numberOfPersons= booking.getNumberOfPersons();
        this.payment=booking.getPayment();
        this.time=booking.getTime();
        this.seatNumber=booking.getSeatNumber();
        this.ticketPrice=booking.getTicketPrice();
        this.totalTicketPrice=booking.getTotalTicketPrice();
    }
}
