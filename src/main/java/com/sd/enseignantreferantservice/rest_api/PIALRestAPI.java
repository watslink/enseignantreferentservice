package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.PIALService;
import com.sd.enseignantreferantservice.model.PIAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PIALRestAPI {


    @Autowired
    private PIALService pialService;

    @GetMapping("/pial/{id}")
    public PIAL getPIAL(@PathVariable int id){
        return  pialService.getPial(id);
    }

    @GetMapping("/pials")
    public List<PIAL> getListPIAL() {
        return pialService.getAllPial();
    }


    @PostMapping("/pial")
    public PIAL addPIAL(@RequestBody PIAL pial){
        return pialService.addPial(pial);
    }

    @PutMapping("/pial")
    public PIAL updatePIAL(@RequestBody PIAL pial){
        return pialService.updatePial(pial);
    }

    @DeleteMapping("/pial")
    public void deletePIAL(@RequestBody PIAL pial){
        pialService.deletePial(pial);
    }
}


