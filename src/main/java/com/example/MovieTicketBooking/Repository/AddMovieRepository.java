package com.example.MovieTicketBooking.Repository;

import com.example.MovieTicketBooking.Model.AddMovies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMovieRepository extends CrudRepository<AddMovies,String> {
}
