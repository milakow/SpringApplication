package com.example.demo.repository;


import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal newPrice);

    List<Product> findByAmountBetween(int minAmount, int maxAmount);

    List<Product> findByShelfNumberIsNotNull();
}
