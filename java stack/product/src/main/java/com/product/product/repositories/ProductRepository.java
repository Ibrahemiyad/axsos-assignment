package com.product.product.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.product.product.models.Product; 
import com.product.product.models.Category;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    // Retrieves all products assigned to a specific category
    List<Product> findAllByCategories(Category category);

    // Retrieves all categories NOT assigned to a specific product
    List<Product> findByCategoriesNotContains(Category category);

}
