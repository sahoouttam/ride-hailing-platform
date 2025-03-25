package com.ride.hailing.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ride.hailing.platform.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
}
