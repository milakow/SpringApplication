package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.model.Product;
import com.example.demo.model.Supermarket;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupermarketService {
    @Autowired
    SupermarketRepository supermarketRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @Autowired
    ManagerRepository managerRepository;
    
    public void addProductToSupermarket(int productId, int supermarketId) {
        Supermarket supermarket = getSupermarketById(supermarketId).get();
        Product product = productService.getProductById(productId).get();
        Supermarket newSupermarket = supermarket;
        product.setSupermarket(supermarket);
        productRepository.save(product);
    }

    public void addMultipleProductsToSupermarket(List<Product> products, int supermarketId) {
        Supermarket supermarket = getSupermarketById(supermarketId).get();
        for (Product product : products) {
            if (!supermarket.getProductList().contains(product)) {
                product.setSupermarket(supermarket);
                productRepository.save(product);

            } else {
                System.out.println("The product " + product.getId() + " already exists!");
            }
        }
    }


    public List<Supermarket> listAllSupermarkets() {
        return supermarketRepository.findAll();
    }

    public Optional<Supermarket> getSupermarketById(int id) {
        return supermarketRepository.findById(id);
    }

    public void addSupermarket(Supermarket supermarket) {
        if (!supermarketRepository.existsById(supermarket.getId())) {
            supermarketRepository.save(supermarket);
        }
    }

    public void deleteSupermarket(int id){
        supermarketRepository.deleteById(id);

    }

    //clear supermarket_id for Manager in database- it’s a parent
    public void deleteSupermarketRelatedToManager(int id) {
        Supermarket supermarket = supermarketRepository.findById(id).get();
        Manager manager = supermarket.getManager();
        manager.setSupermarket(null);
        managerRepository.save(manager);
        supermarketRepository.deleteById(id);
    }
}
