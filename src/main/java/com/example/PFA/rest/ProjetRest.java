package com.example.PFA.rest;

import com.example.PFA.bean.Projet;
import com.example.PFA.payload.ProjetPayload;
import com.example.PFA.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/projet")
public class ProjetRest {


    @Autowired
    private ProjetService projetService;

    @GetMapping("email/{name}")
    public Projet findProjetByProjetName(@PathVariable String name) {
        return projetService.findProjetByProjetName(name);
    }

    @PostMapping("create/")
    public int createProjet(@RequestBody ProjetPayload projet) {
        return projetService.createProjet(projet);
    }

    @GetMapping("answers/{projetName}")
    public ArrayList<String> findAnswers(@PathVariable String projetName) {
        return projetService.findAnswers(projetName);
    }
}
