package com.ride.hailing.platform.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateVehicleRequest {
    
    private String licensePlate;
    private String manufacturer;
    private String model;
    private int capacity;
}
