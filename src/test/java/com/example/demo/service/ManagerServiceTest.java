package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.annotation.Resource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ManagerServiceTest {

    //    @Mock
    @Spy
    ManagerRepository managerRepository;

    @Resource
    @InjectMocks
    ManagerService managerService;

    @BeforeEach
    void onInit() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listAllManagers() {

    }

    @Test
    void getManagerByIdShouldReturnManagerIfExists() {
        //given
        int id = 1;
        Manager manager = new Manager();
        manager.setId(id);
        when(managerRepository.findById(id)).thenReturn(Optional.of(manager));
        //when
        Optional<Manager> result = managerService.getManagerById(id);
        //then
        assertEquals(result.get(), manager);
    }

    @Test
    void addManagerShouldAddManager() {
        //given
        Manager manager = new Manager();
        //when
        managerService.addManager(manager);
        //then
        verify(managerRepository).save(manager);
    }

    @Test
    void addManagerShouldThrowExceptionWhenExists() {
        //given
        int id = 1;
        Manager manager = new Manager();
        manager.setId(id);
        when(managerRepository.existsById(id)).thenReturn(true);
        //when

        //then
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            managerService.addManager(manager);
        });
        assertEquals(e.getMessage(), "Manager with this id exists");
    }

}