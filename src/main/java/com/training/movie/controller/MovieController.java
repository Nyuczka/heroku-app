package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public Iterable<Movie> movies(){
        return movieRepository.findAll();
    }
}