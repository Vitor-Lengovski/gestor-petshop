package com.example.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petshop.interfaceService.InterfacePetService;
import com.example.petshop.model.Pet;


@Controller
@RequestMapping
public class PetController {
    
    @Autowired
    private InterfacePetService service;

    @GetMapping("/listarPets")
    public String listar(Model model){
        List<Pet> pets = service.listAll();
        model.addAttribute("pets", pets);
        return "pets";
    }
    @GetMapping("/novoPet")
    public String agregar(Model model){
        model.addAttribute("pet", new Pet());
        return "formPet";
    }
    @PostMapping("/savePet")
    public String save(Pet p, Model model){
        service.save(p);
        return "redirect:/listarPets";
    }
    @GetMapping("/editarPet/{id}")
    public String update(@PathVariable Long id, Model model){
        Optional<Pet> pet = service.listById(id);
        model.addAttribute("pet", pet);
        return "formPet";
    }

    @GetMapping("/excluirPet/{id}")
    public String delete(Model model, @PathVariable Long id){
        service.delete(id);
        return "redirect:/listarPets";
    }
}
