package com.middleware.demo.repository;

import com.middleware.demo.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OfficerRepository extends JpaRepository<Officer, Integer> {
}
