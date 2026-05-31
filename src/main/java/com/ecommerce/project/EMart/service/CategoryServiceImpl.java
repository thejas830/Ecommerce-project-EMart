package com.ecommerce.project.EMart.service;

import com.ecommerce.project.EMart.exception.APIException;
import com.ecommerce.project.EMart.exception.ResourceNotFoundException;
import com.ecommerce.project.EMart.model.Category;
import com.ecommerce.project.EMart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    //private List<Category> categories = new ArrayList<>();

    //private Long id=1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()){
            throw new APIException("No category created till now");
        }
        return categoryList;
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(id++)
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        /*List<Category> categories = categoryRepository.findAll();
        Category category =categories.stream().filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found"));*/
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()){
            Category deleteCategory =  optionalCategory.get();
            categoryRepository.delete(deleteCategory);
            return "Category with categoryId : "+ deleteCategory.getCategoryId() +" deleted successfully";
        }else{
            throw  new ResourceNotFoundException(categoryId,"categoryId","Category");
        }

//        categories.remove(category);

    }

    @Override
    public Category updateCategory(Long categoryId,Category category) {
        /*List<Category> categories = categoryRepository.findAll();
        Optional<Category> optionalCategory = categories.stream().filter(c-> c.getCategoryId().equals(categoryId)).findFirst();*/
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if(optionalCategory.isPresent()){
            Category existCategory = optionalCategory.get();
            //existCategory.setCategoryId(category.getCategoryId());
            existCategory.setCategoryName(category.getCategoryName());
            Category savedCategory = categoryRepository.save(existCategory);
            return savedCategory;
        }else{
            throw  new ResourceNotFoundException(categoryId,"categoryId","Category");
        }

    }
}
