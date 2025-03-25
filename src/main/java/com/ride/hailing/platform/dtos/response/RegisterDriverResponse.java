package com.ride.hailing.platform.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDriverResponse {
    
    private String name;
    private String address;
    private String licensePlate;
    private String manufacturer;
    private String model;
}
