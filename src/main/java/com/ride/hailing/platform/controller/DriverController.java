package com.ride.hailing.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.hailing.platform.dtos.request.RegisterDriverRequest;
import com.ride.hailing.platform.dtos.response.RegisterDriverResponse;
import com.ride.hailing.platform.service.DriverService;

@RestController
@RequestMapping("/v1")
public class DriverController {
    
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/driver/register")
    public RegisterDriverResponse registerDriver(@RequestBody RegisterDriverRequest registerDriverRequest) {
        RegisterDriverResponse registerDriverResponse = driverService.registerDriver(registerDriverRequest);
        return registerDriverResponse;
    }
}
