package com.example.demo.controller;


import com.example.demo.model.Supermarket;
import com.example.demo.service.SupermarketService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supermarket")
public class SupermarketController {

    @Autowired
    SupermarketService supermarketService;

    @PatchMapping("/{productId}/addProduct/{supermarketId}")
    public void addProductToSupermarket(@PathVariable int productId, @PathVariable int supermarketId){
        supermarketService.addProductToSupermarket(productId, supermarketId);
    }

    @GetMapping("/all")
    public List<Supermarket> listAllSupermarkets() {
        return supermarketService.listAllSupermarkets();
    }

//    @GetMapping("/{id}")
//    public Optional<Supermarket> getSupermarketById(@PathVariable int id){
//        return supermarketService.getSupermarketById(id);
//    }
    //CODE WRITTEN WITH REQUEST PARAM
    @GetMapping("")
    public Optional<Supermarket> getSupermarketById(@RequestParam(name = "supermarketId") int id){
        return supermarketService.getSupermarketById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addsupermarket")
    public void addSupermarket(@RequestBody Supermarket supermarket) {
        supermarketService.addSupermarket(supermarket);
    }

    @DeleteMapping("/{id}")
    public void deleteSupermarket(@PathVariable int id) {
        supermarketService.deleteSupermarket(id);
    }


//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler(ConstraintViolationException.class)
//    String handleIllegalException(ConstraintViolationException e){
//        return e.getConstraintViolations().stream().findFirst().get().getMessage();
//    }
}
