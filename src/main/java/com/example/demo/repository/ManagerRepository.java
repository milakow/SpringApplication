package com.example.demo.repository;

import com.example.demo.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
