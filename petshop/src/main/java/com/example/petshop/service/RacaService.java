package com.example.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshop.interfaceService.InterfaceRacaService;
import com.example.petshop.interfaces.InterfaceRaca;
import com.example.petshop.model.Raca;

@Service
public class RacaService implements InterfaceRacaService{

    @Autowired
    private InterfaceRaca data;

    @Override
    public List<Raca> listAll() {
        return (List<Raca>)data.findAll();
    }

    @Override
    public Optional<Raca> listById(Long id) {
        return data.findById(id);
    }

    @Override
    public int save(Raca r) {
        int res = 0;
        Raca raca = data.save(r);
        if (!raca.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(Long id) {
        data.deleteById(id);
    }
    
}
