package com.enviro.assessment.grad001.KatlegoDhlamini.Controller;

import com.enviro.assessment.grad001.KatlegoDhlamini.Entity.WasteCategory;
import com.enviro.assessment.grad001.KatlegoDhlamini.Services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories")
class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@RequestBody @Validated WasteCategory category) {
        return ResponseEntity.ok(service.saveCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable int id, @RequestBody @Validated WasteCategory category) {
        return ResponseEntity.ok(service.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

//    lookup endpoint
    @GetMapping("/{name}")
    public ResponseEntity<WasteCategory> getCategoryByName(@PathVariable String name) {
        Optional<WasteCategory> category = service.findCategoryByName(name);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}