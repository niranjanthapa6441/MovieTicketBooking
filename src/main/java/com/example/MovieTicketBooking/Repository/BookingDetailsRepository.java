package com.example.MovieTicketBooking.Repository;

import com.example.MovieTicketBooking.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<Booking, String> {

}
