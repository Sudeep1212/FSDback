package com.fullstackdev.fsdv1.repository;

import com.fullstackdev.fsdv1.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    Optional<Registration> findByEmail(String email);
}