package com.ride.hailing.platform.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRideResponse {

    private Long rideId;
    private String userName;
    private String driverName;
    private String startLocation;
    private String endLocation;
}
