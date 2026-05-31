package com.ecommerce.project.EMart.repositories;

import com.ecommerce.project.EMart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends  JpaRepository<Category,Long> {
}
