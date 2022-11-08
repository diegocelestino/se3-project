package com.se3project.repository;

import com.se3project.model.Mouting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoutingRepository extends JpaRepository<Mouting, UUID> {
}
