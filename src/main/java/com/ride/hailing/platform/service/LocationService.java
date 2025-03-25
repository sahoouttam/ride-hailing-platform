package com.ride.hailing.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.hailing.platform.dtos.request.CreateLocationRequest;
import com.ride.hailing.platform.entity.Location;
import com.ride.hailing.platform.repository.LocationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocationService {
    
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(CreateLocationRequest createLocationRequest) {
        Location location = Location.builder()
                        .address(createLocationRequest.getAddress())
                        .latitude(createLocationRequest.getLatitude())
                        .longitude(createLocationRequest.getLongitude())
                        .build();
        return locationRepository.save(location);
    }
}
