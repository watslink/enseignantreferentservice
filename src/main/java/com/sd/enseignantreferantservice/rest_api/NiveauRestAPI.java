package com.sd.enseignantreferantservice.rest_api;


import com.sd.enseignantreferantservice.business.serviceInterface.NiveauService;
import com.sd.enseignantreferantservice.model.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NiveauRestAPI {


    @Autowired
    private NiveauService niveauService;

    @GetMapping("/niveau/{id}")
    public Niveau getNiveau(@PathVariable int id){
        return  niveauService.getNiveau(id);
    }

    @GetMapping("/niveaux")
    public List<Niveau> getListNiveau() {
        return niveauService.getAllNiveau();
    }


    @PostMapping("/niveau")
    public Niveau addNiveau(@RequestBody Niveau niveau){
        return niveauService.addNiveau(niveau);
    }

    @PutMapping("/niveau")
    public Niveau updateNiveau(@RequestBody Niveau niveau){
        return niveauService.updateNiveau(niveau);
    }

    @DeleteMapping("/niveau/{id}")
    public void deleteNiveau(@PathVariable int id){
        niveauService.deleteNiveau(id);
    }
}



