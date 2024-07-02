package com.middleware.demo.repository;
import com.middleware.demo.model.Court;
import com.middleware.demo.model.ECitation;
import com.middleware.demo.model.Officer;
import com.middleware.demo.model.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ECitationRepository extends JpaRepository<ECitation, Integer> {


   Optional<ECitation> findByCourtAndOfficerAndViolation(Court court, Officer officer, Violation violation);
}
