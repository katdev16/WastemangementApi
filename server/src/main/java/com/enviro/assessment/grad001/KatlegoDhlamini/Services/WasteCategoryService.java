package com.enviro.assessment.grad001.KatlegoDhlamini.Services;

import com.enviro.assessment.grad001.KatlegoDhlamini.Entity.WasteCategory;
import com.enviro.assessment.grad001.KatlegoDhlamini.Repo.WasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class WasteCategoryService {
    @Autowired
    private WasteRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }
    public WasteCategory getCategoryById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(int id, WasteCategory categoryDetails) {
        WasteCategory category = getCategoryById(id);
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        category.setRecyclingTip(categoryDetails.getRecyclingTip());
        category.setDisposalGuideline(categoryDetails.getDisposalGuideline());
        return repository.save(category);
    }

    public boolean deleteCategory(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

//    adding waste lookup
    public Optional<WasteCategory> findCategoryByName(String name) {
        return repository.findByNameIgnoreCase(name);
}
}