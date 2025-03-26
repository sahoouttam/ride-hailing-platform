package com.ride.hailing.platform.service;

import com.ride.hailing.platform.dtos.request.RegisterUserRequest;
import com.ride.hailing.platform.dtos.response.RegisterUserResponse;
import com.ride.hailing.platform.entity.Location;
import com.ride.hailing.platform.entity.User;
import com.ride.hailing.platform.exception.EmailAlreadyExistsException;
import com.ride.hailing.platform.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final LocationService locationService;

    @Autowired
    public UserService(UserRepository userRepository, LocationService locationService) {
        this.userRepository = userRepository;
        this.locationService = locationService;
    }

    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        if (userRepository.existsByEmailOrPhoneNumber(
                registerUserRequest.getEmail(), registerUserRequest.getPhoneNumber())) {
            throw new EmailAlreadyExistsException("Email or phone number already registered");
        }
        User user = User.builder()
                .name(registerUserRequest.getName())
                .email(registerUserRequest.getEmail())
                .password(registerUserRequest.getPassword())
                .phoneNumber(registerUserRequest.getPhoneNumber())
                .build();
        User registeredUser = userRepository.save(user);
        Location createdLocation = locationService.createLocation(
                registerUserRequest.getCreateLocationRequest(), registeredUser);
        return new RegisterUserResponse(
                registeredUser.getName(),
                registeredUser.getEmail(),
                registeredUser.getPhoneNumber(),
                createdLocation.getAddress());
    }
}
