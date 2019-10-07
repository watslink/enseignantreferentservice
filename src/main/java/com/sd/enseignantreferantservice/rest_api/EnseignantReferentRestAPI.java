package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EnseignantReferentService;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnseignantReferentRestAPI {


    @Autowired
    private EnseignantReferentService enseignantReferentService;

    @GetMapping("/enseignantReferent/{id}")
    public EnseignantReferent getEnseignantReferent(@PathVariable int id){
        return  enseignantReferentService.getEnseignantReferentById(id);
    }

    @GetMapping("/enseignantReferents")
    public List<EnseignantReferent> getListEnseignantReferent() {
        return enseignantReferentService.getAllEnseignantReferent();
    }


    @PostMapping("/inscription")
    public ResponseEntity<Void> addEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent){
        if (enseignantReferentService.getByMail(enseignantReferent.getMail())!=null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        enseignantReferentService.addEnseignantReferent(enseignantReferent);
        return new ResponseEntity<Void>( HttpStatus.CREATED);
    }

    @PutMapping("/enseignantReferent")
    public EnseignantReferent updateEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent){
        return enseignantReferentService.updateEnseignantReferent(enseignantReferent);
    }

    @DeleteMapping("/enseignantReferent/{id}")
    public void deleteEnseignantReferent(@PathVariable int id){
        enseignantReferentService.deleteEnseignantReferent(id);
    }
}


