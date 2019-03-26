package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String movies(final Model model){
        model.addAttribute("movies",movieRepository.findAll());
        return "movies";
    }

    @GetMapping("/{movieId}")
    public String getDetailsForMovie(@PathVariable final Long movieId, final Model model){
        Optional<Movie> movieById = movieRepository.findById(movieId);
        movieById.ifPresent(movie -> model.addAttribute("movie", movie));
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
