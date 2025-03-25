package com.ride.hailing.platform.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLocationRequest {
    
    private String address;
    private double latitude;
    private double longitude;
}
