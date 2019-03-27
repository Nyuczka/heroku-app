package com.training.movie.service;

import com.training.movie.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ReviewRestService {

    @Value("${heroku.review.url}")
    private String url;


    @Autowired
    private RestTemplate restTemplate;

    public List<Review> getReviewsForMovieId(Long movieId){
        String newUrl = url + "/" + movieId;
        ResponseEntity<List<Review>> response = restTemplate.exchange(newUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        });
        return response.getBody();
    }

}
