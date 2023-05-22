package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public String deleteProductById(int id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }


    public void replaceProduct(int id, Product updatedProduct) {
        if(productRepository.existsById(id)) {
            updatedProduct.setId(id);
            productRepository.save(updatedProduct);
        }
    }

    public void updateProduct(int id, int amount) {
        Product product = productRepository.findById(id).get();
        product.setAmount(amount);
        productRepository.save(product);

    }
}
