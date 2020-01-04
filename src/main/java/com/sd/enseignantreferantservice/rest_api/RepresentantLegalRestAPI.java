package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.RepresentantLegalService;
import com.sd.enseignantreferantservice.model.RepresentantLegal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepresentantLegalRestAPI {


    @Autowired
    private RepresentantLegalService representantLegalService;

    @GetMapping("/representantLegal/{id}")
    public RepresentantLegal getRepresentantLegal(@PathVariable int id) {
        return representantLegalService.getRepresentantLegal(id);
    }

    @GetMapping("/representantsLegaux/{ensRefId}")
    public List<RepresentantLegal> getListRepresentantLegal(@PathVariable int ensRefId) {
        return representantLegalService.getAllRepresentantLegal(ensRefId);
    }

    @PutMapping("/representantLegal")
    public RepresentantLegal updateRepresentantLegal(@RequestBody RepresentantLegal representantLegal) {
        return representantLegalService.updateRepresentantLegal(representantLegal);
    }

    @DeleteMapping("/representantLegal/{id}")
    public void deleteRepresentantLegal(@PathVariable int id) {
        representantLegalService.deleteRepresentantLegal(id);
    }
}


