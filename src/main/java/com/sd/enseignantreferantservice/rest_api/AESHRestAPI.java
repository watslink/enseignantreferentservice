package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.AESHService;
import com.sd.enseignantreferantservice.model.AESH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AESHRestAPI {


    @Autowired
    private AESHService aeshService;

    @GetMapping("/aesh/{id}")
    public AESH getAESH(@PathVariable int id){
        return  aeshService.getAesh(id);
    }

    @GetMapping("/aeshs/{ensRefId}")
    public List<AESH> getListAESH(@PathVariable int ensRefId) {
        return aeshService.getAllAesh(ensRefId);
    }

    @PostMapping("/aesh")
    public AESH addAESH(@RequestBody AESH aesh){
        return aeshService.addAesh(aesh);
    }

    @PutMapping("/aesh")
    public AESH updateAESH(@RequestBody AESH aesh){
        return aeshService.updateAesh(aesh);
    }

    @DeleteMapping("/aesh/{id}")
    public void deleteAESH(@PathVariable int id){
        aeshService.deleteAesh(id);
    }
}


