package com.product.product.services;

import org.springframework.stereotype.Service;

import com.product.product.models.Category;
import com.product.product.models.Product;
import com.product.product.repositories.CategoryRepository;
import com.product.product.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create new Product
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    // Get All Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Add a Category to a Product
    public void addCategoryToProduct(Category category, Long productId) {
        Product product = getProductById(productId);
        if (product != null) {
            if (!product.getCategories().contains(category)) {
                product.getCategories().add(category);
                productRepository.save(product);
            }
        }
    }


    public List<Product> getUnassignedProducts(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }
}