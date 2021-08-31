package com.example.MovieTicketBooking.Model;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Table(name = "BookingDetails")
public class Booking {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String bookingID;
    @Column(name = "MOVIENAME")
    private String movieName;
    @Column(name = "DATE")
    private String date;
    @Column(name = "TIME")
    private String time;
    @Column(name = "HALL")
    private String hall;
    @Column(name = "NUMBER_OF_PERSONS")
    private int numberOfPersons;
    @Column(name = "AUDITORIUM")
    private String auditorium;
    @Column(name = "SEATNUMBER")
    private String seatNumber;

    public Booking() {
    }

    public Booking(String bookingID, String movieName, String date, String time, String hall, int numberOfPersons, String auditorium, String seatNumber) {
        this.bookingID = bookingID;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.hall = hall;
        this.numberOfPersons = numberOfPersons;
        this.auditorium = auditorium;
        this.seatNumber = seatNumber;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
