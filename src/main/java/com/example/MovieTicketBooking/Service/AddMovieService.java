package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.CustomExceptions.MovieNotFoundException;
import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Repository.AddMovieRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddMovieService {
    private final AddMovieRepository addMovieRepository;

    public AddMovieService(AddMovieRepository addMovieRepository) {
        this.addMovieRepository = addMovieRepository;
    }
    public void save(AddMovies addMovies){
        addMovieRepository.save(addMovies);
    }
    public void delete(String id){
        addMovieRepository.deleteById(id);
    }
    public Iterable<AddMovies> getAllMovies(){
        return addMovieRepository.findAll();
    }

    public AddMovies get(String id) throws MovieNotFoundException {
        Optional<AddMovies> result= addMovieRepository.findById(id);
        if(result.isPresent()){
            return  result.get();
        } else {
            throw new MovieNotFoundException("Movie Not found");
        }
    }
    public void deleteMovie(String id){
        addMovieRepository.deleteById(id);
    }
}
