package com.se3project.repository;

import com.se3project.model.Collaborator;
import com.se3project.model.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoordinatorRepository extends JpaRepository<Coordinator, UUID> {
}
