package com.fullstackdev.fsdv1.repository;

import com.fullstackdev.fsdv1.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findByRegistrationId(Integer registrationId);
}