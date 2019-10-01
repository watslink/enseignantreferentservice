package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.dao.StructureProRepository;
import com.sd.enseignantreferantservice.model.StructurePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StructureProRestAPI {


    @Autowired
    private StructureProRepository structureProRepository;

    @GetMapping("/structurePros")
    public List<StructurePro> getListStrucutrePro() {
        return (List<StructurePro>) structureProRepository.findAll();
    }


}

