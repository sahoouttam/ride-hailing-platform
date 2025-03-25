package com.ride.hailing.platform.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRatingRequest {
    
    private int score;
    private long userId;
    private long driverId;
    private long rideId;
}
