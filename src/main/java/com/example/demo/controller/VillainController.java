package com.example.demo.controller;

import com.example.demo.model.Villain;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VillainController {

    public List<Villain> listAllVillains() {
        //get all villains
        return new ArrayList<>();
    }

    public Villain getVillainById(long id) {
        return new Villain();
    }

    public void addVillain(Villain villain) {
        //save in Database
    }

    public void deleteVillain(long id) {

    }

    public void replaceVillain(long id, Villain villain) {
        //overwrite everything
    }

    public void updateVillain(long id, Villain villain) {
        //update new field
    }

}
