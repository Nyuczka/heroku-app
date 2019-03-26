package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONMovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/json/movies")
    public Iterable<Movie> getMovies(){
        return movieRepository.findAll();
    }
}
