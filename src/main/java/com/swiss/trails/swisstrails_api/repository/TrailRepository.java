package com.swiss.trails.swisstrails_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swiss.trails.swisstrails_api.entity.Trail;

public interface TrailRepository extends JpaRepository<Trail, Long> {
    List<Trail> findByDifficulty(String difficulty);
    List<Trail> findByLengthKmLessThan(double maxKm);
}
