package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;
    @NotBlank(message = "Name of product cannot be blank!")
    private String name;
    @Min(value = 1, message = "Min value of amount must be greater or equal than 1!")
    private int amount;

    //    private static final BigDecimal testNum = valueOf(1.0);
    @Min(value = 1, message = "Price cannot be blank!")
    private BigDecimal price;
    private String color;
    private Integer shelfNumber;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "supermarket_id", columnDefinition = "integer")
    private Supermarket supermarket;

    public Product() {

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
