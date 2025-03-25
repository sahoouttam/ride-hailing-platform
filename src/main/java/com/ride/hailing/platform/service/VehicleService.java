package com.ride.hailing.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.hailing.platform.dtos.request.CreateVehicleRequest;
import com.ride.hailing.platform.entity.Driver;
import com.ride.hailing.platform.entity.Vehicle;
import com.ride.hailing.platform.repository.VehicleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehicleService {
    
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle registerVehicle(CreateVehicleRequest createVehicleRequest, Driver driver) {
        Vehicle vehicle = Vehicle.builder()
                        .driver(driver)
                        .licensePlate(createVehicleRequest.getLicensePlate())
                        .manufacturer(createVehicleRequest.getManufacturer())
                        .model(createVehicleRequest.getModel())
                        .capacity(createVehicleRequest.getCapacity())
                        .build();
        return vehicleRepository.save(vehicle);
    }
}
