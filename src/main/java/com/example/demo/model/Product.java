package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column
    private String color;
    @Column
    private Integer shelfNumber;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supermarket_id", columnDefinition = "integer")
    private Supermarket supermarket;

    public Product(){

    }
    public Product(int id, String name, int amount, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Product(int id, String name, int amount, BigDecimal price, String color, int shelfNumber) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.color = color;
        this.shelfNumber = shelfNumber;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Integer shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
}
