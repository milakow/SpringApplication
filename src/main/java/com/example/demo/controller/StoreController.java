package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class StoreController {

    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public List<Product> listAllProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public void getProductById(@PathVariable int id) {
        productService.getProductById(id);
    }


    @PostMapping("/addproduct")
    public void addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        productService.replaceProduct(id, updatedProduct);
    }
//        try {
//            Product product = productRepository.findById(id)
//                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
//            product.setName(updatedProduct.getName());
//            product.setAmount(updatedProduct.getAmount());
//            product.setPrice(updatedProduct.getPrice());
//            final Product updatedProduct = productRepository.save(product);
//    }
//        catch (ResourceNotFoundException e) {
//            return ;
//        }

    @PatchMapping("/{id}/amount/{amount}")
    public void updateProduct(@PathVariable int id, @PathVariable int amount) {
        productService.updateProduct(id, amount);
    }
}
