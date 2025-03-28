package com.enviro.assessment.grad001.KatlegoDhlamini.Controller;

import com.enviro.assessment.grad001.KatlegoDhlamini.Entity.WasteCategory;
import com.enviro.assessment.grad001.KatlegoDhlamini.Exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.KatlegoDhlamini.Exceptions.InvalidInputException;
import com.enviro.assessment.grad001.KatlegoDhlamini.Services.WasteCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;


    // ✅ Get all categories
    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllCategories() {
        List<WasteCategory> categories = service.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @Operation(summary = "Get waste category by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response",
                            content = @Content(schema = @Schema(implementation = WasteCategory.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found")
            })
    // ✅ Get category by ID with error handling
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        WasteCategory category = service.getCategoryById(id);
        if (category == null) {
            throw new ResourceNotFoundException("Category with ID " + id + " not found.");
        }
        return ResponseEntity.ok(category);
    }


    // ✅ Create a new category with validation
    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@RequestBody @Validated WasteCategory category) {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new InvalidInputException("Category name cannot be empty.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCategory(category));
    }

    // ✅ Update category with error handling
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody @Validated WasteCategory category) {
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new InvalidInputException("Category name cannot be empty.");
        }

        WasteCategory updatedCategory = service.updateCategory(id, category);
        if (updatedCategory == null) {
            throw new ResourceNotFoundException("Category with ID " + id + " not found.");
        }

        return ResponseEntity.ok(updatedCategory);
    }


    // ✅ Delete category with error handling
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        boolean deleted = service.deleteCategory(id);
        if (!deleted) {
            throw new ResourceNotFoundException("Category with ID " + id + " not found.");
        }
        return ResponseEntity.noContent().build();
    }

    // ✅ Lookup by name with error handling
    @GetMapping("/lookup")
    public ResponseEntity<WasteCategory> getCategoryByName(@RequestParam String name) {
        Optional<WasteCategory> category = service.findCategoryByName(name);
        return category.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Category '" + name + "' not found."));
    }
}
