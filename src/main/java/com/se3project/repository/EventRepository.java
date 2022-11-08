package com.se3project.repository;

import com.se3project.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
