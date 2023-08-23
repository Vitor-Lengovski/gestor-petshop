package com.example.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshop.interfaceService.InterfacePetService;
import com.example.petshop.interfaces.InterfacePet;
import com.example.petshop.model.Pet;

@Service
public class PetService implements InterfacePetService {
    @Autowired
    private InterfacePet data;

    @Override
    public List<Pet> listAll() {
        return (List<Pet>)data.findAll();
    }

    @Override
    public Optional<Pet> listById(Long id) {
        return data.findById(id);
    }

    @Override
    public int save(Pet p) {
        int res = 0;
        Pet pet = data.save(p);
        if (!pet.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(Long id) {
        data.deleteById(id);
    }
    
}
