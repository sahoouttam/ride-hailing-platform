package com.ride.hailing.platform.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ride.hailing.platform.config.RatingAndFeedbackConfig;
import com.ride.hailing.platform.dtos.request.CreateRatingRequest;
import com.ride.hailing.platform.dtos.response.CreateRatingResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RatingAndFeedbackClient {
    
    private final RatingAndFeedbackConfig ratingAndFeedbackConfig;
    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public RatingAndFeedbackClient(RatingAndFeedbackConfig ratingAndFeedbackConfig) {
        this.ratingAndFeedbackConfig = ratingAndFeedbackConfig;
    }

    public CreateRatingResponse createRating(CreateRatingRequest createRatingRequest) {
        CreateRatingResponse response = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CreateRatingRequest> httpEntity = new HttpEntity<>(createRatingRequest);
            ResponseEntity<CreateRatingResponse> responseEntity = restTemplate.exchange(
                ratingAndFeedbackConfig.getRatingAndFeedbackBaseUrl() + 
                ratingAndFeedbackConfig.getCreateRatingPath(),
                HttpMethod.POST,
                httpEntity,
                CreateRatingResponse.class);
            log.info("Create rating response {}", responseEntity);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response = responseEntity.getBody();   
            }
        } catch (Exception exception) {
            log.error("Exception while creating rating", exception);
        }
        return response;
    }
}
