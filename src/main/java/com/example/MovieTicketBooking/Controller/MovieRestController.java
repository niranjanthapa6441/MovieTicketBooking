package com.example.MovieTicketBooking.Controller;

import com.example.MovieTicketBooking.Model.AddMovies;
import com.example.MovieTicketBooking.Service.AddMovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restAPI/movies")
public class MovieRestController {
    private final AddMovieService addMovieService;

    public MovieRestController(AddMovieService addMovieService) {
        this.addMovieService = addMovieService;
    }

    @GetMapping
    public Iterable<AddMovies> getALlMovies(){
        return addMovieService.getAllMovies();
    }
}
