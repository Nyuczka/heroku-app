package com.training.movie.service;

import com.training.movie.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    public Double getMean(List<Review> reviews){
        if(reviews.isEmpty()){
            return null;
        }
        Double mean = 0.0;
        for(Review review : reviews){
            mean += Double.valueOf(review.getRating());
        }
        return mean/reviews.size();
    }


}
