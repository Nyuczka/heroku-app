package com.training.movie.service;

import com.training.movie.model.Review;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
        HttpEntity<String> request = new HttpEntity<>(getHeadersWithAuthentication(getAuthentication()));
        String newUrl = url + "/" + movieId;
        ResponseEntity<List<Review>> response = restTemplate.exchange(newUrl, HttpMethod.GET, request, new ParameterizedTypeReference<List<Review>>() {
        });
        return response.getBody();
    }

    private HttpHeaders getHeadersWithAuthentication(String authentication){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic " + authentication);
        return headers;
    }

    private String getAuthentication(){
        String plainCreds = "user:password";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

}
