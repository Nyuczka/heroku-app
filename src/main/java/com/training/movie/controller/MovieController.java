package com.training.movie.controller;

import com.training.movie.model.Movie;
import com.training.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
