package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.Adresse;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.StructurePro;
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
public class StructureProServiceImplTest {

    @Autowired
    StructureProServiceImpl structureProService;

    @Test
    @Transactional
    @Rollback
    public void addStructurePro() {
        StructurePro structurePro = new StructurePro();
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        structurePro.setEnseignantReferent(ensRef);
        structurePro.setMail("mail@mail.com");
        structurePro.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        structurePro.setAdresse(adresse);
        structurePro.setNom("nom");
        structurePro.setSpecialite("spe");
        StructurePro structureProAdded = structureProService.addStructurePro(structurePro);
        assertEquals("nom" , structureProAdded.getNom());
        assertEquals("mail@mail.com" , structureProAdded.getMail());
        assertEquals("06.06.06.06.06" , structureProAdded.getTelephone());
        assertEquals("spe" , structureProAdded.getSpecialite());
        assertEquals(adresse , structureProAdded.getAdresse());
        assertEquals(ensRef , structureProAdded.getEnseignantReferent());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteStructurePro() {
        structureProService.deleteStructurePro(1);
        assertNull(structureProService.getStructurePro(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateStructurePro() {
        StructurePro structurePro = structureProService.getStructurePro(1);
        structurePro.setNom("nouveau nom");
        StructurePro structureProUpdated = structureProService.updateStructurePro(structurePro);
        assertEquals("nouveau nom", structureProUpdated.getNom());
    }

    @Test
    public void getStructurePro() {
        assertEquals("Chatelain", structureProService.getStructurePro(1).getNom());
    }

    @Test
    public void getStructureProWithIdNotExist() {
        assertNull(structureProService.getStructurePro(75));
    }

    @Test
    public void getAllStructurePro() {
        assertEquals(5, structureProService.getAllStructurePro(1).size());
    }
}
