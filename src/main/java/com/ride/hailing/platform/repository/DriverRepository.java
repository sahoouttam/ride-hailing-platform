package com.ride.hailing.platform.repository;


import com.ride.hailing.platform.entity.Driver;
import com.ride.hailing.platform.entity.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    boolean existsByEmail(String email);

    Optional<List<Driver>> findByDriverStatus(DriverStatus driverStatus);
    
}
