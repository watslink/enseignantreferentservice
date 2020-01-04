package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.AESH;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.PIAL;
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
public class AESHServiceImplTest {

    @Autowired
    AESHServiceImpl aeshService;

    @Test
    @Transactional
    @Rollback
    public void addAesh() {
        AESH aesh = new AESH();
        PIAL pial = new PIAL();
        pial.setPialId(1);
        aesh.setPial(pial);
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        aesh.setEnseignantReferent(ensRef);
        aesh.setMail("mail@mail.com");
        aesh.setTelephone("06.06.06.06.06");
        aesh.setNom("nom");
        aesh.setPrenom("prenom");
        AESH aeshAdded = aeshService.addAesh(aesh);
        assertEquals("nom", aeshAdded.getNom());
        assertEquals("prenom", aeshAdded.getPrenom());
        assertEquals("mail@mail.com", aeshAdded.getMail());
        assertEquals("06.06.06.06.06", aeshAdded.getTelephone());
        assertEquals(ensRef, aeshAdded.getEnseignantReferent());
        assertEquals(pial, aeshAdded.getPial());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteAesh() {
        aeshService.deleteAesh(1);
        assertNull(aeshService.getAesh(1));
    }

    @Test
    @Transactional
    @Rollback
    public void getAllAesh() {
        assertEquals(15, aeshService.getAllAesh(1).size());
    }

    @Test
    public void getAesh() {
        assertEquals("Tessier", aeshService.getAesh(1).getNom());
    }

    @Test
    public void getAeshWithIdNotExist() {
        assertNull(aeshService.getAesh(75));
    }

    @Test
    public void updateAesh() {
        AESH aesh = aeshService.getAesh(1);
        aesh.setPrenom("updatedPrenom");
        AESH aeshUpdated = aeshService.updateAesh(aesh);
        assertEquals("updatedPrenom", aeshUpdated.getPrenom());
    }
}
