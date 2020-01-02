package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.Niveau;
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
public class NiveauServiceImplTest {

    @Autowired
    NiveauServiceImpl niveauService;

    @Test
    @Rollback
    @Transactional
    public void addNiveau() {
        Niveau niveau = new Niveau();
        niveau.setDegre(1);
        niveau.setLibelle("nouveau");
        niveau.setSpecialise(false);
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        niveau.setEnseignantReferent(ensRef);
        Niveau niveauSaved = niveauService.addNiveau(niveau);
        assertEquals("nouveau", niveauSaved.getLibelle());
        assertFalse(niveauSaved.isSpecialise());
        assertEquals(1, niveauSaved.getDegre());
        assertEquals(ensRef, niveauSaved.getEnseignantReferent());
    }

    @Test
    @Rollback
    @Transactional
    public void deleteNiveau() {
        niveauService.deleteNiveau(1);
        assertNull(niveauService.getNiveau(1));
    }


    @Test
    @Rollback
    @Transactional
    public void updateNiveau() {
        Niveau niveau = niveauService.getNiveau(1);
        niveau.setLibelle("updated");
        Niveau niveauUpdated = niveauService.updateNiveau(niveau);
        assertEquals("updated", niveauUpdated.getLibelle());
    }

    @Test
    public void getNiveau() {
        assertEquals("TPS", niveauService.getNiveau(1).getLibelle());
    }

    @Test
    public void getNiveauWithIdNotExist() {
        assertNull(niveauService.getNiveau(75));
    }

    @Test
    public void getAllNiveau() {
        assertEquals(23, niveauService.getAllNiveau(1).size());
    }
}
