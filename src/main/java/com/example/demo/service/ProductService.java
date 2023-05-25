package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public List<Product> listAllProducts();

    public Optional<Product> getProductById(int id);

    public List<Product> getProductByName(String name);

    public List<Product> getProductsWithPriceGreaterThan(BigDecimal declaredPrice);

    public List<Product> getProductsWithAmountBetween(int minAmount, int maxAmount);

    public List<Product> getProductsFromSpecificShelf();


    public void addProduct(Product product);

    public void massAdding(List<Product> products);

    public void deleteProductById(int id);

    public void massDeletion(List<Integer> ids);


    public void replaceProduct(int id, Product updatedProduct);

    public void updateProduct(int id, int amount);
    public void updateProductColor(int id, String color);

    public void updateShelfNumber(int id, Integer shelfNumber);
}
