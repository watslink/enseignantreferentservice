package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtablissementServiceImplTest {

    @Autowired
    EtablissementServiceImpl etablissementService;

    @Test
    @Transactional
    @Rollback
    public void addEtablissement() {
        Etablissement etablissement = new Etablissement();
        PIAL pial=new PIAL();
        pial.setPialId(1);
        etablissement.setPial(pial);
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        etablissement.setEnseignantReferent(ensRef);
        etablissement.setMail("mail@mail.com");
        etablissement.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        etablissement.setAdresse(adresse);
        etablissement.setNom("nom");
        etablissement.setRne("1234567R");
        Etablissement etablissementAdded = etablissementService.addEtablissement(etablissement);
        assertEquals("nom" , etablissementAdded.getNom());
        assertEquals("mail@mail.com" , etablissementAdded.getMail());
        assertEquals("06.06.06.06.06" , etablissementAdded.getTelephone());
        assertEquals(adresse , etablissementAdded.getAdresse());
        assertEquals(ensRef , etablissementAdded.getEnseignantReferent());
        assertEquals(pial, etablissementAdded.getPial());
        assertEquals("1234567R", etablissementAdded.getRne());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteEtablissement() {
        etablissementService.deleteEtablissement(1);
        assertNull(etablissementService.getEtablissement(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateEtablissement() {
        Etablissement etablissement = etablissementService.getEtablissement(1);
        etablissement.setNom("updated");
        Etablissement etablissementUpdated = etablissementService.updateEtablissement(etablissement);
        assertEquals("updated", etablissementUpdated.getNom());
    }

    @Test
    public void getEtablissement() {
        assertEquals("Boyer Malo", etablissementService.getEtablissement(1).getNom());
    }

    @Test
    public void getEtablissementWithIdNotExist() {
        assertNull(etablissementService.getEtablissement(75));
    }

    @Test
    public void getAllEtablissement() {
        assertEquals(15, etablissementService.getAllEtablissement(1).size());
    }
}
