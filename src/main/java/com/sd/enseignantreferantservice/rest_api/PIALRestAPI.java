package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.PIALService;
import com.sd.enseignantreferantservice.model.PIAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PIALRestAPI {


    @Autowired
    private PIALService pIALService;

    @GetMapping("/pIAL/{id}")
    public PIAL getPIAL(@PathVariable int id){
        return  pIALService.getPial(id);
    }

    @GetMapping("/pIALs")
    public List<PIAL> getListStrucutrePro() {
        return pIALService.getAllPial();
    }


    @PostMapping("/pIAL")
    public PIAL addPIAL(@RequestBody PIAL pIAL){
        return pIALService.addPial(pIAL);
    }

    @PutMapping("/pIAL")
    public PIAL updatePIAL(@RequestBody PIAL pIAL){
        return pIALService.updatePial(pIAL);
    }

    @DeleteMapping("/pIAL")
    public void deletePIAL(@RequestBody PIAL pIAL){
        pIALService.deletePial(pIAL);
    }
}


