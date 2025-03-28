package com.ride.hailing.platform.service;

import com.ride.hailing.platform.dtos.request.BookRideRequest;
import com.ride.hailing.platform.dtos.response.BookRideResponse;
import com.ride.hailing.platform.entity.*;
import com.ride.hailing.platform.exception.DriversNotFoundException;
import com.ride.hailing.platform.repository.LocationRepository;
import com.ride.hailing.platform.repository.RideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RideService {

    private final RideRepository rideRepository;
    private final DriverService driverService;
    private final UserService userService;
    private final LocationService locationService;

    @Autowired
    public RideService(RideRepository rideRepository,
                       DriverService driverService,
                       UserService userService,
                       LocationService locationService) {
        this.rideRepository = rideRepository;
        this.driverService = driverService;
        this.userService = userService;
        this.locationService = locationService;
    }

    public BookRideResponse bookRide(BookRideRequest bookRideRequest) {
        Driver availableDriver = driverService.findDrivers(DriverStatus.AVAILABLE)
                .stream()
                .findAny()
                .orElseThrow(() -> new DriversNotFoundException("No driver found at the moment"));
        User user = userService.findUser(bookRideRequest.getUserId());
        Location source = locationService.findLocation(bookRideRequest.getStartId());
        Location destination = locationService.findLocation(bookRideRequest.getEndId());
        Ride ride = Ride.builder()
                .user(user)
                .driver(availableDriver)
                .source(source)
                .destination(destination)
                .build();
        Ride rideBooked = rideRepository.save(ride);
        return new BookRideResponse(rideBooked.getId(),
                user.getName(),
                availableDriver.getName(),
                source.getAddress(),
                destination.getAddress());
    }


}
