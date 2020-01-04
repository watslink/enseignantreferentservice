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
    public EnseignantReferent getEnseignantReferent(@PathVariable int id) {
        return enseignantReferentService.getEnseignantReferentById(id);
    }

    @GetMapping("/enseignantReferentByMail/{mail}")
    public EnseignantReferent getEnseignantReferentByMail(@PathVariable String mail) {
        return enseignantReferentService.getByMail(mail);
    }

    @GetMapping("/enseignantReferents")
    public List<EnseignantReferent> getListEnseignantReferent() {
        return enseignantReferentService.getAllEnseignantReferent();
    }


    @PostMapping("/inscription")
    public ResponseEntity<Void> addEnseignantReferent(@RequestBody EnseignantReferent enseignantReferent) {
        if (enseignantReferentService.getByMail(enseignantReferent.getMail()) != null) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        enseignantReferentService.addEnseignantReferent(enseignantReferent);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/enseignantReferentMail")
    public EnseignantReferent updateMailEnseignantReferent(@RequestParam("id") int id, @RequestParam("newMail") String newMail) {
        return enseignantReferentService.updateMailOfEnseignantReferent(id, newMail);
    }

    @PutMapping("/enseignantReferentPassword")
    public Boolean updatePasswordEnseignantReferent(@RequestParam("id") int id, @RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass) {
        return enseignantReferentService.updatePasswordOfEnseignantReferent(id, oldPass, newPass);
    }

    @DeleteMapping("/enseignantReferent/{id}")
    public void deleteEnseignantReferent(@PathVariable int id) {
        enseignantReferentService.deleteEnseignantReferent(id);
    }

    @GetMapping("/enseignantReferentReinitRDV/{id}")
    public void reinitializeAllRDV(@PathVariable int id) {
        enseignantReferentService.reinitializeAllRDV(id);
    }
}


