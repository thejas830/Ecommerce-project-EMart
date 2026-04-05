package com.ecommerce.project.EMart.service;

import com.ecommerce.project.EMart.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);


    String deleteCategory(Long categoryId);
}
