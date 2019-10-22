package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.CategorieService;
import com.sd.enseignantreferantservice.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieRestAPI {


    @Autowired
    private CategorieService categorieService;

    @GetMapping("/categorie/{id}")
    public Categorie getCategorie(@PathVariable int id){
        return  categorieService.getCategorie(id);
    }

    @GetMapping("/categories/{ensRefId}")
    public List<Categorie> getListCategorie(@PathVariable int ensRefId) {
        return categorieService.getAllCategorie(ensRefId);
    }


    @PostMapping("/categorie")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    }

    @PutMapping("/categorie")
    public Categorie updateCategorie(@RequestBody Categorie categorie){
        return categorieService.updateCategorie(categorie);
    }

    @DeleteMapping("/categorie/{id}")
    public void deleteCategorie(@PathVariable int id){
        categorieService.deleteCategorie(id);
    }
}


