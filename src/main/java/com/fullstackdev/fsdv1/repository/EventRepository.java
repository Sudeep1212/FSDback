package com.fullstackdev.fsdv1.repository;

import com.fullstackdev.fsdv1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}