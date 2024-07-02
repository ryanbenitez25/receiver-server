package com.middleware.demo.repository;

import com.middleware.demo.model.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JudgeRepository  extends JpaRepository<Judge, Integer> {
}
