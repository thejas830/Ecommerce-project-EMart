package com.ecommerce.project.EMart.controller;

import com.ecommerce.project.EMart.model.Category;
import com.ecommerce.project.EMart.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryConrtoller {

    private CategoryService categoryService;

    public CategoryConrtoller(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId){
        String stauts = categoryService.deleteCategory(categoryId);
        return stauts;
    }
}
