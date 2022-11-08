package com.se3project.repository;

import com.se3project.model.Demouting;
import com.se3project.model.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeaderRepository extends JpaRepository<Leader, UUID> {
}
