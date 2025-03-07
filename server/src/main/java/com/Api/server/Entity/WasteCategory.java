package com.Api.server.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Entity
@Table(name = "waste_categories")
public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Category name is required")
    @Size(max = 100, message = "Category name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private String disposalGuideline;

    private String recyclingTip;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getRecyclingTip() { return recyclingTip; }
    public void setRecyclingTip(String recyclingTip) { this.recyclingTip = recyclingTip; }
    public String getDisposalGuideline() { return disposalGuideline; }
    public void setDisposalGuideline(String disposalGuideline) { this.disposalGuideline = disposalGuideline; }

}