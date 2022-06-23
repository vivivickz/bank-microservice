package com.abc.authorizationservice.integration.repository;

import com.abc.authorizationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByEmailId(String emailId);
    Boolean existsByEmailId(String email);
}
