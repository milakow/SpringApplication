package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PatchMapping("/{managerId}/addSupermarket/{supermarketId}")
    public void addSupermarketToManager(@PathVariable int managerId, @PathVariable int supermarketId){
        managerService.addSupermarketToManager(managerId, supermarketId);
    }
    @GetMapping("/all")
    public List<Manager> listAllManagers() {
        return managerService.listAllManagers();
    }

    @GetMapping("/{id}")
    public Optional<Manager> getManagerById(@PathVariable int id) {
        return managerService.getManagerById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addmanager")
    public void addManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }


}
