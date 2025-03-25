package com.ride.hailing.platform.service;


import com.ride.hailing.platform.entity.Vehicle;
import com.ride.hailing.platform.exception.DriversNotFoundException;
import com.ride.hailing.platform.exception.EmailAlreadyExistsException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.hailing.platform.dtos.request.RegisterDriverRequest;
import com.ride.hailing.platform.dtos.response.RegisterDriverResponse;
import com.ride.hailing.platform.entity.Driver;
import com.ride.hailing.platform.entity.DriverStatus;
import com.ride.hailing.platform.entity.Location;
import com.ride.hailing.platform.repository.DriverRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DriverService {
    
    private final DriverRepository driverRepository;
    private final VehicleService vehicleService;
    private final LocationService locationService;
    @Autowired
    public DriverService(DriverRepository driverRepository, 
                            VehicleService vehicleService, 
                            LocationService locationService) {
        this.driverRepository = driverRepository;
        this.vehicleService = vehicleService;
        this.locationService = locationService;
    }

    public RegisterDriverResponse registerDriver(RegisterDriverRequest registerDriverRequest) {
        if (driverRepository.existsByEmail(registerDriverRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already registered");
        }
        Location driverLocation = locationService.saveLocation(registerDriverRequest.getCreateLocationRequest()); 
        Driver driver = Driver.builder()
                        .name(registerDriverRequest.getName())
                        .email(registerDriverRequest.getEmail())
                        .password(registerDriverRequest.getPassword())
                        .phoneNumber(registerDriverRequest.getPhoneNumber())
                        .driverStatus(DriverStatus.OFFLINE)
                        .location(driverLocation)
                        .build();
        Driver registeredDriver = driverRepository.save(driver);
        Vehicle registeredVehicle = vehicleService.registerVehicle(registerDriverRequest.getCreateVehicleRequest(), registeredDriver);
        return new RegisterDriverResponse(
            registeredDriver.getName(),
            driverLocation.getAddress(),
            registeredVehicle.getLicensePlate(),
            registeredVehicle.getManufacturer(),
            registeredVehicle.getModel());
    }

    public List<Driver> findDrivers(DriverStatus driverStatus) {
        Optional<List<Driver>> drivers = driverRepository.findByDriverStatus(driverStatus);
        if (drivers.isEmpty() || drivers.get().isEmpty()) {
            throw new DriversNotFoundException("No driver found at the moment");
        }
        return drivers.get();
    }
}
