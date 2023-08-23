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

import com.example.petshop.interfaceService.InterfaceRacaService;
import com.example.petshop.model.Raca;

@Controller
@RequestMapping
public class RacaController {
    
    @Autowired
    private InterfaceRacaService service;

    @GetMapping("/listarRacas")
    public String listar(Model model){
        List<Raca>racas = service.listAll();
        model.addAttribute("racas", racas);
        return "racas";
    }
    @GetMapping("/novaRaca")
    public String agregar(Model model){
        model.addAttribute("raca", new Raca());
        return "formRaca";
    }
    @PostMapping("/saveRaca")
    public String save(Raca r, Model model){
        service.save(r);
        return "redirect:/listarRacas";
    }
    @GetMapping("/editarRaca/{id}")
    public String update(@PathVariable Long id, Model model){
        Optional<Raca> raca = service.listById(id);
        model.addAttribute("raca", raca);
        return "formRaca";
    }

    @GetMapping("/excluirRaca/{id}")
    public String delete(Model model, @PathVariable Long id){
        service.delete(id);
        return "redirect:/listarRacas";
    }

}
