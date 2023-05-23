package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="supermarket")
public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "supermarket")
    @Column
    List<Product> productList;


    public Supermarket(){}
    public Supermarket(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
