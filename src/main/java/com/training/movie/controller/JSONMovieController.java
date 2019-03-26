package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/json")
public class JSONMovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public Iterable<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movie/{movieId}")
    public Movie getMovie(@PathVariable Long movieId){
        Optional<Movie> byId = movieRepository.findById(movieId);
        return byId.orElse(null);
    }
}
