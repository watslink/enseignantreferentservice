package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.Adresse;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.RepresentantLegal;
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
public class RepresentantLegalServiceImplTest {

    @Autowired
    RepresentantLegalServiceImpl representantLegalService;

    @Test
    @Transactional
    @Rollback
    public void addRepresentantLegal() {
        RepresentantLegal representantLegal = new RepresentantLegal();
        Eleve eleve=new Eleve();
        eleve.setEleveId(1);
        representantLegal.setEleve(eleve);
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        representantLegal.setEnseignantReferent(ensRef);
        representantLegal.setMail("mail@mail.com");
        representantLegal.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        representantLegal.setAdresse(adresse);
        representantLegal.setIdentite("identite");
        RepresentantLegal representantLegal1Added = representantLegalService.addRepresentantLegal(representantLegal);
        assertEquals("identite" , representantLegal1Added.getIdentite());
        assertEquals("mail@mail.com" , representantLegal1Added.getMail());
        assertEquals("06.06.06.06.06" , representantLegal1Added.getTelephone());
        assertEquals(adresse , representantLegal1Added.getAdresse());
        assertEquals(ensRef , representantLegal1Added.getEnseignantReferent());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteRepresentantLegal() {
        representantLegalService.deleteRepresentantLegal(1);
        assertNull(representantLegalService.getRepresentantLegal(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateRepresentantLegal() {
        RepresentantLegal representantLegal = representantLegalService.getRepresentantLegal(1);
        representantLegal.setIdentite("updated identite");
        RepresentantLegal representantLegalUpdated = representantLegalService.updateRepresentantLegal(representantLegal);
        assertEquals("updated identite", representantLegalUpdated.getIdentite());
    }

    @Test
    public void getRepresentantLegal() {
        assertEquals("Duval Agathe", representantLegalService.getRepresentantLegal(1).getIdentite());
    }

    @Test
    public void getRepresentantLegalWithIdNotExist() {
        assertNull(representantLegalService.getRepresentantLegal(75));
    }

    @Test
    public void getAllRepresentantLegal() {
        assertEquals(19, representantLegalService.getAllRepresentantLegal(1).size());
    }
}
