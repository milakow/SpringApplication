package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Profile({"prod", "dev"})
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsWithPriceGreaterThan(BigDecimal declaredPrice) {
        List<Product> products = productRepository.findByPriceGreaterThan(declaredPrice);
        return products;
    }

    @Override
    public List<Product> getProductsWithAmountBetween(int minAmount, int maxAmount) {
        return productRepository.findByAmountBetween(minAmount, maxAmount);
    }

    @Override
    public List<Product> getProductsFromSpecificShelf() {
        return productRepository.findByShelfNumberIsNotNull();
    }


    @Override
    public void addProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            productRepository.save(product);
        } else throw new IllegalArgumentException("The product already exists!");
    }

    @Override
    public void massAdding(List<Product> products) {
        for (Product product : products) {
            if (!productRepository.existsById(product.getId())) {
                productRepository.save(product);
            } else {
                System.out.println("The product " + product.getId() + " already exists!");
            }
        }
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void massDeletion(List<Integer> ids) {
        for (Integer id : ids) {
            if (productRepository.existsById(id)){
                productRepository.deleteById(id);
            }
        }
    }

    @Override
    public void replaceProduct(int id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            productRepository.save(updatedProduct);
        } else throw new IllegalArgumentException("The product does not exist!");
    }

    @Override
    public void updateProduct(int id, int amount) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setAmount(amount);
            productRepository.save(newProduct);
        } else throw new IllegalArgumentException("The product with this is cannot be found.");
    }

    @Override
    public void updateProductColor(int id, String color) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setColor(color);
            productRepository.save(newProduct);
        }
    }

    @Override
    public void updateShelfNumber(int id, Integer shelfNumber) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setShelfNumber(shelfNumber);
            productRepository.save(newProduct);
        }
    }
}
