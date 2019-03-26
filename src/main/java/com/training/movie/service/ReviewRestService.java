package com.training.movie.service;

import com.training.movie.model.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ReviewRestService {

    @Value("${heroku.review.url}")
    private String url;


    public List<Review> getResponse(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsAsyncClientHttpRequestFactory());
        ResponseEntity<List<Review>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        });
        return response.getBody();
    }

}
