package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnseignantReferentServiceImplTest {

    @Autowired
    EnseignantReferentServiceImpl enseignantReferentService;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @Transactional
    @Rollback
    public void addEnseignantReferent() {
        EnseignantReferent enseignantReferent = new EnseignantReferent();
        enseignantReferent.setNom("nom");
        enseignantReferent.setPrenom("prenom");
        enseignantReferent.setMotDePasse("pass");
        enseignantReferent.setMail("mail@mail.com");
        enseignantReferent.setEnabled(true);
        EnseignantReferent enseignantReferentAdded = enseignantReferentService.addEnseignantReferent(enseignantReferent);
        assertEquals("nom", enseignantReferentAdded.getNom());
        assertEquals("prenom", enseignantReferentAdded.getPrenom());
        assertEquals("mail@mail.com", enseignantReferentAdded.getMail());
        assertTrue(enseignantReferentAdded.isEnabled());
        assertTrue(encoder.matches( "pass", enseignantReferentAdded.getMotDePasse()));
    }

    @Test
    @Transactional
    @Rollback
    public void deleteEnseignantReferent() {
        enseignantReferentService.deleteEnseignantReferent(1);
        assertNull(enseignantReferentService.getEnseignantReferentById(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateMailOfEnseignantReferent() {
        enseignantReferentService.updateMailOfEnseignantReferent(1, "new@new.new");
        assertEquals("new@new.new", enseignantReferentService.getEnseignantReferentById(1).getMail());
    }

    @Test
    @Transactional
    @Rollback
    public void updatePasswordOfEnseignantReferent() {
        enseignantReferentService.updatePasswordOfEnseignantReferent(1, "motdepasse", "newpassword");
        assertTrue(encoder.matches("newpassword", enseignantReferentService.getEnseignantReferentById(1).getMotDePasse()));
    }

    @Test
    @Transactional
    @Rollback
    public void updatePasswordOfEnseignantReferentWithWrongOldPassword() {
        enseignantReferentService.updatePasswordOfEnseignantReferent(1, "motde", "newpassword");
        assertFalse(encoder.matches("newpassword", enseignantReferentService.getEnseignantReferentById(1).getMotDePasse()));
    }

    @Test
    public void getByMail() {
        EnseignantReferent enseignantReferent = enseignantReferentService.getByMail("jean.dupont@mail.com");
        assertEquals(1, enseignantReferent.getEnseignantReferentId());
    }

    @Test
    public void getEnseignantReferentById() {
        EnseignantReferent enseignantReferent = enseignantReferentService.getEnseignantReferentById(1);
        assertEquals("jean.dupont@mail.com", enseignantReferent.getMail());
    }

    @Test
    public void getAllEnseignantReferent() {
        assertEquals(1, enseignantReferentService.getAllEnseignantReferent().size());
    }

    @Test
    @Transactional
    @Rollback
    public void reinitializeAllRDV() {
        enseignantReferentService.reinitializeAllRDV(1);
        for(Eleve eleve : enseignantReferentService.getEnseignantReferentById(1).getListEleves()) {
            assertNull(eleve.getDateReunion());
        }
    }
}
