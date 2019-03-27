package com.training.movie.model;


public class MovieReview {
    private Movie movie;
    private Double mean;

    public MovieReview(Movie movie, Double mean) {
        this.movie = movie;
        this.mean = mean;
    }

    public Movie getMovie() {
        return movie;
    }

    public Double getMean() {
        return mean;
    }
}
