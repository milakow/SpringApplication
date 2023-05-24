package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;

    @NotNull(message = "Please provide name!")
//    @NotEmpty
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "supplier_supermarket_mapping", joinColumns = @JoinColumn(name = "supermarket_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    List<Supermarket> supermarketList;

    public Supplier() {
    }

    public Supplier(int id, String name) {
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

    public List<Supermarket> getSupermarketList() {
        return supermarketList;
    }

    public void setSupermarketList(List<Supermarket> supermarketList) {
        this.supermarketList = supermarketList;
    }
}
