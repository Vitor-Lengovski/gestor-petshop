package com.example.petshop.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.model.Pet;

@Repository
public interface InterfacePet extends CrudRepository<Pet, Long>{
    
}
