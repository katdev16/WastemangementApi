package com.enviro.assessment.grad001.KatlegoDhlamini.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enviro.assessment.grad001.KatlegoDhlamini.Entity.WasteCategory;

import java.util.Optional;


public interface WasteRepository extends JpaRepository<WasteCategory, Integer> {
    Optional<WasteCategory> findByNameIgnoreCase(String name);
}