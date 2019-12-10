package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.business.serviceInterface.FileService;
import com.sd.enseignantreferantservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EleveRestAPI {


    @Autowired
    private EleveService eleveService;

    @GetMapping("/eleve/{id}")
    public Eleve getEleve(@PathVariable int id){

        return  eleveService.getEleve(id);
    }

    @GetMapping("/eleves/{ensRefId}")
    public List<Eleve> getListEleve(@PathVariable int ensRefId) {
        return eleveService.getAllEleve(ensRefId);
    }

    @GetMapping("/eleves/inscrits/{ensRefId}")
    public List<Eleve> getListEleveInscrits(@PathVariable int ensRefId) {
        return eleveService.getAllEleveInscrits(ensRefId);
    }

    @GetMapping("/eleves/noninscrits/{ensRefId}")
    public List<Eleve> getListEleveNonInscrits(@PathVariable int ensRefId) {
        return eleveService.getAllEleveInsciptionEnCours(ensRefId);
    }

    @GetMapping("/eleves/vus/{ensRefId}")
    public List<Eleve> getListEleveVus(@PathVariable int ensRefId) {
        return eleveService.getAllEleveVu(ensRefId);
    }

    @GetMapping("/eleves/nonvus/{ensRefId}")
    public List<Eleve> getListEleveNonVus(@PathVariable int ensRefId) {
        return eleveService.getAllEleveNonVu(ensRefId);
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
        for(RepresentantLegal representantLegal: eleve.getListRepresentantsLegaux()){
            representantLegal.setEleve(eleve);
        }
        for(EleveStructurePro eleveStructurePro: eleve.getListEleveStructurePros()){
            eleveStructurePro.setEleve(eleve);
            eleveStructurePro.setPk(new EleveStructurePro.PK(eleveStructurePro.getStructurePro().getStructureProId(), eleve.getEleveId()));
        }
        for(Document document: eleve.getListDocuments()){
            document.setEleve(eleve);
        }
        return eleveService.updateEleve(eleve);
    }

    @DeleteMapping("/eleve/{id}")
    public void deleteEleve(@PathVariable int id){
        eleveService.deleteEleve(id);
    }

}


