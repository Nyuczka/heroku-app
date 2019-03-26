package com.training.movie.controller;

import com.training.movie.model.Review;
import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import com.training.movie.service.ReviewRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/{movieId}/reviews")
    public List<Review> getReviewsForMovie(@PathVariable Long movieId){
       return reviewRestService.getResponse().stream().filter(review -> review.getMovieId().equals(movieId)).collect(Collectors.toList());
    }

    @GetMapping("/reviews")
    public List<Review> getReviews(){
        return reviewRestService.getResponse();
    }
}
