package com.middleware.demo.repository;

import com.middleware.demo.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourtRepository extends JpaRepository<Court, Integer> {
}
