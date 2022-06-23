package com.abc.userregistration.integration.repository;

import com.abc.userregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByLastName(String lastname);
    User findByEmailId(String emailId);
}
