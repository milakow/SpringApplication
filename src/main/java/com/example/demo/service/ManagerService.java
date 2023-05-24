package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.model.Supermarket;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    SupermarketService supermarketService;

    public void addSupermarketToManager(int managerId, int supermarketId){
        Manager manager = getManagerById(managerId).get();
        Supermarket supermarket = supermarketService.getSupermarketById(supermarketId).get();
        manager.setSupermarket(supermarket);
        managerRepository.save(manager);
    }

    public List<Manager> listAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(int id) {
        return managerRepository.findById(id);
    }

    public void addManager(Manager manager) {
        if (!managerRepository.existsById(manager.getId())) {
            managerRepository.save(manager);
        }
    }



}
