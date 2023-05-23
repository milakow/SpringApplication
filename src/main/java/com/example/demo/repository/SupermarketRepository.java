package com.example.demo.repository;


import com.example.demo.model.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermarketRepository extends JpaRepository<Supermarket, Integer> {


}
