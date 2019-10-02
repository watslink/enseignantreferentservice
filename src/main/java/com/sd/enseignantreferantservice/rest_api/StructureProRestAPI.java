package com.sd.enseignantreferantservice.rest_api;


import com.sd.enseignantreferantservice.business.serviceInterface.StructureProService;
import com.sd.enseignantreferantservice.model.StructurePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StructureProRestAPI {


    @Autowired
    private StructureProService structureProService;

    @GetMapping("/structurePro/{id}")
    public StructurePro getStructurePro(@PathVariable int id){
       return  structureProService.getStructurePro(id);
    }

    @GetMapping("/structurePros")
    public List<StructurePro> getListStructurePro() {
        return structureProService.getAllStructurePro();
    }


    @PostMapping("/structurePro")
    public StructurePro addStructurePro(@RequestBody StructurePro structurePro){
        return structureProService.addStructurePro(structurePro);
    }

    @PutMapping("/structurePro")
    public StructurePro updateStructurePro(@RequestBody StructurePro structurePro){
        return structureProService.updateStructurePro(structurePro);
    }

    @DeleteMapping("/structurePro")
    public void deleteStructurePro(@RequestBody StructurePro structurePro){
        structureProService.deleteStructurePro(structurePro);
    }
}

