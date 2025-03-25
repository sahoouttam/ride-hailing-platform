package com.ride.hailing.platform.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRatingResponse {
    
    private long ratingId;
    private int score;
    private long rideId;
}
