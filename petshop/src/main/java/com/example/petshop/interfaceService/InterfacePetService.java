package com.example.petshop.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.petshop.model.Pet;

public interface InterfacePetService {
    
    public List<Pet> listAll();
    public Optional<Pet> listById(Long id);
    public int save(Pet pet);
    public void delete(Long id); 
}
