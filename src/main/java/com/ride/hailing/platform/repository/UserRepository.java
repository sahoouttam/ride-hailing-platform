package com.ride.hailing.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.hailing.platform.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
