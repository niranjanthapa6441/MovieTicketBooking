package com.example.MovieTicketBooking.Model;

public class BookingData {
    private String bookingID;

    public BookingData(String bookingID) {
        this.bookingID = bookingID;
    }

    public BookingData() {
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
}
