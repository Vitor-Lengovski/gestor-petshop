package com.example.petshop.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.petshop.model.Raca;


public interface InterfaceRacaService {
    public List<Raca> listAll();
    public Optional<Raca> listById(Long id);
    public int save(Raca raca);
    public void delete(Long id); 
}
