package com.example.petshop.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.model.Raca;

@Repository
public interface InterfaceRaca extends CrudRepository<Raca, Long> {
    
}
