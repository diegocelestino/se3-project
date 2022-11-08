package com.se3project.repository;

import com.se3project.model.Collaborator;
import com.se3project.model.Demouting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DemoutingRepository extends JpaRepository<Demouting, UUID> {
}
