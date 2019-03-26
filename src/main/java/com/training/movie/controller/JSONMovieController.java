package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import com.training.movie.service.ReviewRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/json/movies")
public class JSONMovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    ReviewRestService reviewRestService;

    @GetMapping()
    public Iterable<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable Long movieId){
        Optional<Movie> byId = movieRepository.findById(movieId);
        return byId.orElse(null);
    }

}
