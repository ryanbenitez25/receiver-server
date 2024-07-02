package com.middleware.demo.repository;

import com.middleware.demo.model.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ViolationRepository extends JpaRepository<Violation, Integer> {
}

