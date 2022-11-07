package com.se3project.repository;

import com.se3project.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CollaboratorRepository extends JpaRepository<Collaborator, UUID> {
}
