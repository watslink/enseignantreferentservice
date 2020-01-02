package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.PIAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PIALServiceImplTest {

    @Autowired
    PIALServiceImpl pialService;


    @Test
    @Rollback
    @Transactional
    public void addPial() {
        PIAL pial = new PIAL();
        pial.setNom("Lille");
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        pial.setEnseignantReferent(ensRef);
        pialService.addPial(pial);
        assertEquals("Lille" , pialService.getAllPial(1).get(0).getNom());
    }

    @Test
    @Rollback
    @Transactional
    public void deletePial() {
        pialService.deletePial(1);
        assertNull(pialService.getPial(1));
    }

    @Test
    @Rollback
    @Transactional
    public void updatePial() {
        PIAL pial = pialService.getPial(1);
        pial.setNom("Arras");
        pialService.updatePial(pial);
        assertEquals("Arras", pialService.getPial(1).getNom());
    }

    @Test
    public void getPial() {
        PIAL pial = pialService.getPial(1);
        assertEquals("Somain", pial.getNom());
    }

    @Test
    public void getPialNotExist() {
        PIAL pial = pialService.getPial(75);
        assertNull(pial);
    }

    @Test
    public void getAllPial() {
        assertEquals(2, pialService.getAllPial(1).size());
    }
}
