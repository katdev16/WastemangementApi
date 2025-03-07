package com.Api.server.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Api.server.Entity.WasteCategory;


public interface WasteRepository extends JpaRepository<WasteCategory, Integer> {}