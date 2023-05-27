package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Supermarket;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupermarketRepository;
import com.example.demo.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SupplierServiceTest {
    @Mock
    SupplierRepository supplierRepository;

    @Mock
    SupermarketRepository supermarketRepository;

    @InjectMocks
    SupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void addSupermarketToSupplier() {
//        // given
//        int supplierId = 1;
//        int supermarketId = 1;
//        Supplier supplier = new Supplier();
//        supplier.setId(supplierId);
//        Supermarket supermarket = new Supermarket();
//        supermarket.setId(supermarketId);
//
//        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
//        when(supermarketRepository.findById(supermarketId)).thenReturn(Optional.of(supermarket));
//
//        // when
//        supplierService.addSupermarketToSupplier(supplierId, supermarketId);
//
//        // then
//        verify(supplierRepository).save(supplier);
//        assertEquals(1, supplier.getSupermarketList().size());
//        assertEquals(supermarket, supplier.getSupermarketList().get(0));
//    }

    @Test
    void listAllSuppliers() {
        // given
        List<Supplier> supplierList = new ArrayList<>();
        when(supplierRepository.findAll()).thenReturn(supplierList);

        // when
        List<Supplier> result = supplierService.listAllSuppliers();

        // then
        assertEquals(supplierList, result);
    }

    @Test
    void getSupplierByIdShouldReturnSupplierIfExists() {
        // given
        int supplierId = 1;
        Supplier supplier = new Supplier();
        supplier.setId(supplierId);

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));

        // when
        Optional<Supplier> result = supplierService.getSupplierById(supplierId);

        // then
        assertEquals(supplier, result.get());
    }

    @Test
    void addSupplierShouldAddSupplier() {
        // given
        Supplier supplier = new Supplier();

        // when
        supplierService.addSupplier(supplier);

        // then
        verify(supplierRepository).save(supplier);
    }
}