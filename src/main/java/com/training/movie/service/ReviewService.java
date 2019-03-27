package com.training.movie.service;

import com.training.movie.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    public Double getMeanOfReviewsByMovieId(Long movieId,List<Review> reviews){
        Double mean = 0.0;
        List<Review> reviewsByMovieId = reviews.stream().filter(review -> review.getMovieId().equals(movieId)).collect(Collectors.toList());
        for(Review review : reviewsByMovieId){
            mean += Double.valueOf(review.getRating());
        }
        return mean/reviewsByMovieId.size();
    }

    public Double getMean(List<Review> reviews){
        Double mean = 0.0;
        for(Review review : reviews){
            mean += Double.valueOf(review.getRating());
        }
        return mean/reviews.size();
    }


}
