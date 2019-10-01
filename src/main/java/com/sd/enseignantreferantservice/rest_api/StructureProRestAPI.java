package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.dao.StructureProRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.StructurePro;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StructureProRestAPI {


    @Autowired
    private StructureProRepository structureProRepository;

    @Autowired
    EleveService eleveService;

    @GetMapping("/structurePros")
    public List<StructurePro> getListStrucutrePro() {
        return (List<StructurePro>) structureProRepository.findAll();
    }

    @GetMapping("/eleves")
    public List<Eleve> getListEleve(){return eleveService.getAllEleve();}
}

