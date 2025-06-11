package com.product.product.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.product.product.models.Category;
import com.product.product.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    // Retrieves all categories assigned to a specific product
    List<Category> findAllByProducts(Product product);

    // Retrieves all categories NOT assigned to a specific product
    List<Category> findByProductsNotContains(Product product);

}
