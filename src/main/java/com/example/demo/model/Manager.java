package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private int id;
    @NotNull(message = "Message can't be null.")
    private String surname;

    @OneToOne
    @JoinColumn(name = "supermarket_id", columnDefinition = "integer")
    private Supermarket supermarket;

    public Manager() {
    }

    public Manager(int id, String surname) {
        this.id = id;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
}
