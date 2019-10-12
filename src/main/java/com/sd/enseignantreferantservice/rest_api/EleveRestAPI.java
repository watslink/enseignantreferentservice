package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EleveRestAPI {


    @Autowired
    private EleveService eleveService;

    @GetMapping("/eleve/{id}")
    public Eleve getEleve(@PathVariable int id){
        return  eleveService.getEleve(id);
    }

    @GetMapping("/eleves")
    public List<Eleve> getListEleve() {
        return eleveService.getAllEleve();
    }

    @GetMapping("/eleves/inscrits")
    public List<Eleve> getListEleveInscrits() {
        return eleveService.getAllEleveInscrits();
    }

    @GetMapping("/eleves/noninscrits")
    public List<Eleve> getListEleveNonInscrits() {
        return eleveService.getAllEleveInsciptionEnCours();
    }

    @GetMapping("/eleves/vus")
    public List<Eleve> getListEleveVus() {
        return eleveService.getAllEleveVu();
    }

    @GetMapping("/eleves/nonvus")
    public List<Eleve> getListEleveNonVus() {
        return eleveService.getAllEleveNonVu();
    }

    @PostMapping("/elevevalidate")
    public Eleve validateInscription(@RequestBody Eleve eleve){
        return eleveService.validateInscription(eleve);
    }

    @PostMapping("/eleve")
    public Eleve addEleve(@RequestBody Eleve eleve){
        return eleveService.addEleve(eleve);
    }

    @PutMapping("/eleve")
    public Eleve updateEleve(@RequestBody Eleve eleve){
        return eleveService.updateEleve(eleve);
    }

    @DeleteMapping("/eleve/{id}")
    public void deleteEleve(@PathVariable int id){
        eleveService.deleteEleve(id);
    }

}


