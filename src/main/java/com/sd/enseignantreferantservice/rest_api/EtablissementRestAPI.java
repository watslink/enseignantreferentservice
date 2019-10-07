package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EtablissementService;
import com.sd.enseignantreferantservice.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtablissementRestAPI {


    @Autowired
    private EtablissementService etablissementService;

    @GetMapping("/etablissement/{id}")
    public Etablissement getEtablissement(@PathVariable int id){
        return  etablissementService.getEtablissement(id);
    }

    @GetMapping("/etablissements")
    public List<Etablissement> getListEtablissement() {
        return etablissementService.getAllEtablissement();
    }


    @PostMapping("/etablissement")
    public Etablissement addEtablissement(@RequestBody Etablissement etablissement){
        return etablissementService.addEtablissement(etablissement);
    }

    @PutMapping("/etablissement")
    public Etablissement updateEtablissement(@RequestBody Etablissement etablissement){
        return etablissementService.updateEtablissement(etablissement);
    }

    @DeleteMapping("/etablissement/{id}")
    public void deleteEtablissement(@PathVariable int id){
        etablissementService.deleteEtablissement(id);
    }
}


