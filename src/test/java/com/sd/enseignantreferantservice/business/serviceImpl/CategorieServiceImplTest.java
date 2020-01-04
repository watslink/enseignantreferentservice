package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.Categorie;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceImplTest {

    @Autowired
    CategorieServiceImpl categorieService;

    @Test
    @Transactional
    @Rollback
    public void addCategorie() {
        Categorie categorie = new Categorie();
        categorie.setNom("nom");
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        categorie.setEnseignantReferent(ensRef);
        Categorie categorieAdded = categorieService.addCategorie(categorie);
        assertEquals("nom", categorieAdded.getNom());
        assertEquals(ensRef, categorieAdded.getEnseignantReferent());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteCategorie() {
        categorieService.deleteCategorie(1);
        assertNull(categorieService.getCategorie(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateCategorie() {
        Categorie categorie = categorieService.getCategorie(1);
        categorie.setNom("Updated");
        Categorie categorieUpdated = categorieService.updateCategorie(categorie);
        assertEquals("Updated", categorieUpdated.getNom());
    }

    @Test
    public void getCategorie() {
        assertEquals("Administratif", categorieService.getCategorie(1).getNom());
    }

    @Test
    public void getCategorieWithIdNotExist() {
        assertNull(categorieService.getCategorie(75));
    }

    @Test
    public void getAllCategorie() {
        assertEquals(4, categorieService.getAllCategorie(1).size());
    }
}
