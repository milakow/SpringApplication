package com.example.demo.controller;

import com.example.demo.model.Supplier;
import com.example.demo.service.SupermarketService;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
//    @Autowired
//    SupermarketService supermarketService;
    @PatchMapping("/{supplierId}/addSupermarket/{supermarketId}")
    public void addSupplierToSupermarket(@PathVariable int supplierId, @PathVariable int supermarketId){
        supplierService.addSupermarketToSupplier(supplierId, supermarketId);
    }
    @GetMapping("/all")
    public List<Supplier> listAllSuppliers(){
        return supplierService.listAllSuppliers();
    }

//    @GetMapping("/{id}")
//    public Optional<Supplier> getSupplierById(@PathVariable int id){
//        return supplierService.getSupplierById(id);
//    }
//    @GetMapping("")
//    public List<Supplier> getSupplierById(@RequestParam(name = "id", required = false) int id){
//        if(!Optional.ofNullable(id).isPresent()) {
//            return supplierService.listAllSuppliers();
//        }
//        Optional<Supplier> optionalSupplier = supplierService.getSupplierById(id);
//        if (optionalSupplier.isPresent())
//            return List.of(optionalSupplier.get());
//        return List.of();
//    }

    @GetMapping("")
    public Optional<Supplier> getSupplierById(@RequestHeader(name = "id") int id){
        return supplierService.getSupplierById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addsupplier")
    public void addSupplier(@RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
    }
}
