package com.okavango.parking_api.repository;

import com.okavango.parking_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}