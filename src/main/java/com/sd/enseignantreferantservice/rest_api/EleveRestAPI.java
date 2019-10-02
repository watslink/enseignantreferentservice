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


    @PostMapping("/eleve")
    public Eleve addEleve(@RequestBody Eleve eleve){
        return eleveService.addEleve(eleve);
    }

    @PutMapping("/eleve")
    public Eleve updateEleve(@RequestBody Eleve eleve){
        return eleveService.updateEleve(eleve);
    }

    @DeleteMapping("/eleve")
    public void deleteEleve(@RequestBody Eleve eleve){
        eleveService.deleteEleve(eleve);
    }
}


