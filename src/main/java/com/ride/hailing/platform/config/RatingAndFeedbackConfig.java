package com.ride.hailing.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class RatingAndFeedbackConfig {
    
    @Value("${rating.and.feedback.base.url}")
    private String ratingAndFeedbackBaseUrl;

    private String createRatingPath = "/rfs/api/v1/rating/create";
}
