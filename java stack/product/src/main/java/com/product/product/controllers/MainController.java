package com.product.product.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.product.product.models.Category;
import com.product.product.models.Product;
import com.product.product.services.CategoryService;
import com.product.product.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.List;

@Controller
public class MainController {

    private final ProductService productService;
    private final CategoryService categoryService;
    public MainController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/products/new")
    public String newProduct(
            @ModelAttribute("newProduct") Product newProduct
    ) {
        return "newProduct";
    }

    @GetMapping("/categories/new")
    public String newCategory(
            @ModelAttribute("newCategory") Category newCategory
    ) {
        return "newCategory";
    }

    // Post Request Mapping
    @PostMapping("addNewProduct")
    public String addNewProduct(
            @Valid @ModelAttribute("newProduct") Product newProduct,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "newProduct";
        }
        else {
            productService.addNewProduct(newProduct);
            return "redirect:/";
        }
    }

    @PostMapping("/addNewCategory")
    public String addNewCategory(
            @Valid @ModelAttribute("newCategory") Category newCategory,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "newCategory";
        }
        else {
            categoryService.addNewCategory(newCategory);
            return "redirect:/";
        }
    }

    // Show product & Add Category to Product
    @GetMapping("/products/{productId}")
    public String showProduct(
            Model model,
            @PathVariable("productId") Long productId,
            @ModelAttribute("category") Category category
    ) {
        Product product = productService.getProductById(productId);
        List<Category> unassignedCategories = categoryService.getUnassignedCategories(product);
        model.addAttribute("product", product);
        model.addAttribute("unassignedCategories", unassignedCategories);
        return "product";
    }

    @PostMapping("/products/{productId}/addCategory")
    public String addCategoryToProduct(
            @ModelAttribute("category") Category category,
            @PathVariable Long productId
    ) {
        productService.addCategoryToProduct(category,productId);
        return "redirect:/products/" + productId;
    }



    // Show Category & Add Product to Category
    @GetMapping("/categories/{categoryId}")
    public String showCategory(
            Model model,
            @PathVariable("categoryId") Long categoryId,
            @ModelAttribute("product") Product product
    ) {
        Category category = categoryService.getCategoryById(categoryId);
        List<Product> unassignedProducts = productService.getUnassignedProducts(category);
        model.addAttribute("category", category);
        model.addAttribute("unassignedProducts", unassignedProducts);
        return "category";
    }

    @PostMapping("/categories/{categoryId}/addProduct")
    public String addProductToCategory(
            @ModelAttribute("product") Product product,
            @PathVariable Long categoryId
    ) {
        categoryService.addProductToCategory(product,categoryId);
        return "redirect:/categories/" + categoryId;
    }

}
