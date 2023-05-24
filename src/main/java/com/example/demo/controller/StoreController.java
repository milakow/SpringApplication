package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * // 1) Add service method and controller End-point to query by name/your field
 * // 2) Add 2-3 new fields to your entity - check if table is updated (use spring.jpa.hibernate.ddl-auto=update if you haven't already)
 * // 3) Add a patch method used only to update new fields
 * // 4) Create new 3 methods to retrieve data in the repository (greaterThan, Like, Not, Between, True, etc.)
 * // 5) Add corresponding service and controller methods to retrieve data
 */
@RestController
@RequestMapping("/products")
public class StoreController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/named/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/price/greaterthan/{declaredPrice}")
    public List<Product> getProductsWithPriceGreaterThan(@PathVariable BigDecimal declaredPrice) {
        return productService.getProductsWithPriceGreaterThan(declaredPrice);
    }

    @GetMapping("/amount/between/{minNum}/{maxNum}")
    public List<Product> getProductsWithAmountBetween(@PathVariable int minNum, @PathVariable int maxNum) {
        return productService.getProductsWithAmountBetween(minNum, maxNum);
    }

    @GetMapping("/shelf/not/null")
    public List<Product> getProductsFromShelf() {
        return productService.getProductsFromSpecificShelf();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        productService.replaceProduct(id, updatedProduct);
    }


    @PatchMapping("/{id}/amount/{amount}")
    public void updateProduct(@PathVariable int id, @PathVariable int amount) {
        productService.updateProduct(id, amount);
    }

    @PatchMapping("/{id}/color")
    public void updateProductColor(@PathVariable int id, @RequestBody String color) {
        productService.updateProductColor(id, color);
    }

    @PatchMapping("/{id}/shelf")
    public void updateShelfNumber(@PathVariable int id, @RequestBody Integer shelfNumber) {
        productService.updateShelfNumber(id, shelfNumber);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IllegalArgumentException.class)
    void handleIllegalException(Exception e) {
        System.out.println(e.getMessage());
    }
}
