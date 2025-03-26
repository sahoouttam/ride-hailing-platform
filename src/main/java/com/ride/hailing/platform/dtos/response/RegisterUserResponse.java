package com.ride.hailing.platform.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserResponse {
    
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
