//package com.Api.server.Services;
//
//import Entity.WasteCategory;
//import Repo.WasteCategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.List;
//
//@Service
//@Validated
//public class WasteCategoryService {
//    @Autowired
//    private WasteCategoryRepository repository;
//
//    public List<WasteCategory> getAllCategories() {
//        return repository.findAll();
//    }
//    public WasteCategory getCategoryById(int id) {
//        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
//    }
//
//    public WasteCategory saveCategory(WasteCategory category) {
//        return repository.save(category);
//    }
//
//    public WasteCategory updateCategory(int id, WasteCategory categoryDetails) {
//        WasteCategory category = getCategoryById(id);
//        category.setName(categoryDetails.getName());
//        category.setDescription(categoryDetails.getDescription());
//        category.setRecyclingTip(categoryDetails.getRecyclingTip());
//        category.setDisposalGuideline(categoryDetails.getDisposalGuideline());
//        return repository.save(category);
//    }
//
//    public void deleteCategory(int id) {
//        WasteCategory category = getCategoryById(id);
//        repository.delete(category);
//    }
//}