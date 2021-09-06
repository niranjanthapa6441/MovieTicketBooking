package com.example.MovieTicketBooking.Model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Booking_Details_Paging")
public class Booking {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String bookingID;
    @Column(name = "MOVIENAME")
    private String movieName;
    @Column(name = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "HALL")
    private String hall;
    @Column(name = "NUMBER_OF_PERSONS")
    private int numberOfPersons;
    @Column(name = "AUDITORIUM")
    private String auditorium;
    @Column(name = "SEAT_NUMBER")
    private String seatNumber;
    @Column(name = "TICKET_PRICE")
    private int ticketPrice;
    @Column(name = "TOTAL_TICKET_PRICE")
    private int totalTicketPrice;
    @Column(name = "PAYMENT")
    private String payment;
    public Booking() {
    }
    public Booking(String bookingID,
                   String movieName,
                   LocalDate date,
                   String time,
                   String hall,
                   int numberOfPersons,
                   String auditorium,
                   String seatNumber,
                   int ticketPrice,
                   int totalTicketPrice,
                   String payment) {
        this.bookingID = bookingID;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.numberOfPersons = numberOfPersons;
        this.auditorium = auditorium;
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
        this.totalTicketPrice = totalTicketPrice;
        this.payment = payment;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(int totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
