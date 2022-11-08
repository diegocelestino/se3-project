
package com.se3project.repository;

import com.se3project.model.Attendant;
import com.se3project.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendantRepository extends JpaRepository<Attendant, UUID> {
}
