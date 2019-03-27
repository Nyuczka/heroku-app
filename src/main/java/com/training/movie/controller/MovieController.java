package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.model.MovieReview;
import com.training.movie.model.Review;
import com.training.movie.repository.MovieRepository;
import com.training.movie.service.ReviewRestService;
import com.training.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieRepository movieRepository;

    private ReviewRestService reviewRestService;

    private ReviewService reviewService;

    @Autowired
    public MovieController(MovieRepository movieRepository, ReviewRestService reviewRestService, ReviewService reviewService){
        this.movieRepository = movieRepository;
        this.reviewRestService = reviewRestService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public String movies(final Model model){
        Iterable<Movie> movies = movieRepository.findAll();
        List<MovieReview> movieReviews = new ArrayList<>();
        for(Movie movie: movies){
            List<Review> reviewsForMovieId = reviewRestService.getReviewsForMovieId(movie.getMovieId());
            movieReviews.add(new MovieReview(movie,reviewService.getMean(reviewsForMovieId)));
        }
        model.addAttribute("movieWithMeans",movieReviews);
        return "movies";
    }

    @GetMapping("/{movieId}")
    public String getDetailsForMovie(@PathVariable final Long movieId, final Model model){
        Optional<Movie> movieById = movieRepository.findById(movieId);
        movieById.ifPresent(movie -> model.addAttribute("movie", movie));
        List<Review> reviews = reviewRestService.getReviewsForMovieId(movieId);
        model.addAttribute("reviews",reviews);
        model.addAttribute("mean",reviewService.getMean(reviews));
        return "movieDetails";
    }

    @GetMapping("/showAddMovieForm")
    public String showAddMovieForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "forms/addMovieForm";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        movieRepository.save(movie);
        return "redirect:/movies";
    }
}
