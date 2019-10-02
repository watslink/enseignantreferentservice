package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.EnseignantReferentService;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/enseignantReferent")
    public EnseignantReferent addEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent){
        return enseignantReferentService.addEnseignantReferent(enseignantReferent);
    }

    @PutMapping("/enseignantReferent")
    public EnseignantReferent updateEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent){
        return enseignantReferentService.updateEnseignantReferent(enseignantReferent);
    }

    @DeleteMapping("/enseignantReferent")
    public void deleteEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent){
        enseignantReferentService.deleteEnseignantReferent(enseignantReferent);
    }
}


