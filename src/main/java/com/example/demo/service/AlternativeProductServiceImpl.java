package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Primary
@Profile("test")
public class AlternativeProductServiceImpl implements ProductService {

    @Value("${com.example.MyProperty}")
    Integer num;

    @Override
    public List<Product> listAllProducts() {
        System.out.println("list all products- 2nd part");
        Random random = new Random();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < num; i++){
            Product product = new Product();
            product.setId(i);
            product.setName("product name " + (i + 1));
            product.setAmount(random.nextInt(1, 30));
            BigDecimal randomBD = new BigDecimal(random.nextDouble(1, 25));
            randomBD = randomBD.setScale(2, RoundingMode.HALF_UP);
            product.setPrice(randomBD);
            productList.add(product);
        }

        return productList;
    }

    @Override
    public Optional<Product> getProductById(int id) {
        System.out.println("get product by id");
        return Optional.empty();
    }

    @Override
    public List<Product> getProductByName(String name) {
        System.out.println("get product by name");
        return new ArrayList<>();
    }

    @Override
    public List<Product> getProductsWithPriceGreaterThan(BigDecimal declaredPrice) {
        System.out.println("get products with price greater than");
        return new ArrayList<>();
    }

    @Override
    public List<Product> getProductsWithAmountBetween(int minAmount, int maxAmount) {
        System.out.println("getProductsWithAmountBetween");
        return new ArrayList<>();
    }

    @Override
    public List<Product> getProductsFromSpecificShelf() {
        System.out.println("getProductsWithAmountBetween");
        return new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("addProduct");
    }

    @Override
    public void massAdding(List<Product> products) {System.out.println("massAdding");

    }

    @Override
    public void deleteProductById(int id) {
        System.out.println("deleteProductById");
    }

    @Override
    public void massDeletion(List<Integer> ids) {
        System.out.println("massDeletion");
    }
    @Override
    public void replaceProduct(int id, Product updatedProduct) {
        System.out.println("replaceProduct");

    }

    @Override
    public void updateProduct(int id, int amount) {
        System.out.println("updateProduct");

    }

    @Override
    public void updateProductColor(int id, String color) {
        System.out.println("updateProductColor");

    }

    @Override
    public void updateShelfNumber(int id, Integer shelfNumber) {
        System.out.println("updateShelfNumber");

    }


}
