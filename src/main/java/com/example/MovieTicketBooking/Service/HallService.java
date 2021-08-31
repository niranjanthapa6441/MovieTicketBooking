package com.example.MovieTicketBooking.Service;

import com.example.MovieTicketBooking.CustomExceptions.HallNotFoundException;
import com.example.MovieTicketBooking.CustomExceptions.MovieNotFoundException;
import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Model.Hall;
import com.example.MovieTicketBooking.Repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HallService {
    private final HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }
    public void addHalls(Hall hall){
        hallRepository.save(hall);
    }
    public Iterable<Hall> getAllHalls(){
        return hallRepository.findAll();
    }
    public Hall get(String id) throws HallNotFoundException {
        Optional<Hall> result= hallRepository.findById(id);
        if(result.isPresent()){
            return  result.get();
        } else {
            throw new HallNotFoundException("Hall Not found");
        }
    }
    public void deleteMovie(String id){
        hallRepository.deleteById(id);
    }
}
