package com.example.demo.service;

import com.example.demo.model.Supermarket;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupermarketRepository;
import com.example.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupermarketRepository supermarketRepository;
    public void addSupermarketToSupplier(int supplierId, int supermarketId) {
        Supplier supplier = supplierRepository.findById(supplierId).get();
        Supermarket supermarket = supermarketRepository.findById(supermarketId).get();
        supplier.getSupermarketList().add(supermarket);
        supplierRepository.save(supplier);
    }

    public List<Supplier> listAllSuppliers(){
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getSupplierById(int id) {
        return supplierRepository.findById(id);
    }

    public void addSupplier(Supplier supplier){
        if(!supplierRepository.existsById(supplier.getId())){
            supplierRepository.save(supplier);
        }
    }
}
