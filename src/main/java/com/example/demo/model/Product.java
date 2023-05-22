package com.example.demo.model;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;


@Entity
@Table(name= "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;

    @Column
    private String name;

    @Column
    private int amount;

    @Column
    private BigDecimal price;

    public Product(){

    }
//    public Product(long id, String name, int amount, double price) {
//        this.id = id;
//        this.name = name;
//        this.amount = amount;
//        this.price = price;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
