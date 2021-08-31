package com.example.MovieTicketBooking.Repository;

import com.example.MovieTicketBooking.Model.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository<Hall,String> {
}
