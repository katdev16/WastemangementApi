package com.Api.server.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Api.server.Entity.WasteCategory;

import java.util.Optional;


public interface WasteRepository extends JpaRepository<WasteCategory, Integer> {
    Optional<WasteCategory> findByNameIgnoreCase(String name);
}