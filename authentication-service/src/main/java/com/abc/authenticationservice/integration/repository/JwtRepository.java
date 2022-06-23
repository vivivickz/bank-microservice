package com.abc.authenticationservice.integration.repository;

import com.abc.authenticationservice.model.JwtRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtRepository extends JpaRepository<JwtRequest,String> {

    Optional<JwtRequest> findByEmailId(String emailId);
    Boolean existsByEmailId(String email);
}
