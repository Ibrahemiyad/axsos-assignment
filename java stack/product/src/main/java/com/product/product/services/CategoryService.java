package com.product.product.services;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.models.Category;
import com.product.product.models.Product;
import com.product.product.repositories.CategoryRepository;
import com.product.product.repositories.ProductRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create New Category
    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get Product by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Add a Product to a Category
    public void addProductToCategory(Product product, Long categoryId) {
        Category category = getCategoryById(categoryId);
        if (category != null) {
            if (!category.getProducts().contains(product)) {
                category.getProducts().add(product);
                categoryRepository.save(category);
            }
        }
    }

    public List<Category> getUnassignedCategories(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }

}
