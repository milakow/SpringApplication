package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsWithPriceGreaterThan(BigDecimal declaredPrice) {
        List<Product> products = productRepository.findByPriceGreaterThan(declaredPrice);
        return products;
    }

    public List<Product> getProductsWithAmountBetween(int minAmount, int maxAmount) {
        return productRepository.findByAmountBetween(minAmount, maxAmount);
    }

    public List<Product> getProductsFromSpecificShelf() {
        return productRepository.findByShelfNumberIsNotNull();
    }


    public void addProduct(Product product) {
//        if (productRepository.existsById(product.getId()))  {
//            System.out.println("Product already exists");
//        } else {
//            productRepository.save(product);
//        }
        if (!productRepository.existsById(product.getId())) {
            productRepository.save(product);
        } else throw new IllegalArgumentException("The product already exists!");
    }


    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }


    public void replaceProduct(int id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            productRepository.save(updatedProduct);
        } else throw new IllegalArgumentException("The product does not exist!");
    }

    public void updateProduct(int id, int amount) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setAmount(amount);
            productRepository.save(newProduct);
        } else throw new IllegalArgumentException("The product with this is cannot be found.");
    }

    public void updateProductColor(int id, String color) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setColor(color);
            productRepository.save(newProduct);
        }
    }

    public void updateShelfNumber(int id, Integer shelfNumber) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setShelfNumber(shelfNumber);
            productRepository.save(newProduct);
        }
    }
}
