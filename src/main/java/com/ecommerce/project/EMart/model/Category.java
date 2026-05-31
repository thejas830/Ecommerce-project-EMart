package com.ecommerce.project.EMart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long categoryId;

        /*@Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq")
        @SequenceGenerator(name = "order_seq",sequenceName = "order_sequence",allocationSize = 1)
        private Long categoryId;*/
        @NotBlank
        @Size (min = 5 ,message = "Category Name must at least be 5 charters")
        private String categoryName;
}
