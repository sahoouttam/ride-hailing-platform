package com.ride.hailing.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ride.hailing.platform.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);
}
