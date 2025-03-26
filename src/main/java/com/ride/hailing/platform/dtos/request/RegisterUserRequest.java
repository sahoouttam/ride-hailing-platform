package com.ride.hailing.platform.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRequest {

    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private CreateLocationRequest createLocationRequest;
}
