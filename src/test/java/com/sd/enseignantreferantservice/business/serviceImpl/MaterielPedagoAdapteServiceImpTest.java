package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
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
public class MaterielPedagoAdapteServiceImpTest {

    @Autowired
    MaterielPedagoAdapteServiceImp materielPedagoAdapteService;

    @Test
    @Rollback
    @Transactional
    public void addMaterielPedagoAdapte() {
        MaterielPedagoAdapte materielPedagoAdapte = new MaterielPedagoAdapte();
        materielPedagoAdapte.setNom("nom");
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        materielPedagoAdapte.setEnseignantReferent(ensRef);
        MaterielPedagoAdapte materielPedagoAdapteSaved = materielPedagoAdapteService.addMaterielPedagoAdapte(materielPedagoAdapte);
        assertEquals("nom", materielPedagoAdapteSaved.getNom());
        assertEquals(ensRef, materielPedagoAdapteSaved.getEnseignantReferent());
    }

    @Test
    @Rollback
    @Transactional
    public void deleteMaterielPedagoAdapte() {
        materielPedagoAdapteService.deleteMaterielPedagoAdapte(1);
        assertNull(materielPedagoAdapteService.getMaterielPedagoAdapte(1));
    }

    @Test
    @Rollback
    @Transactional
    public void updateMaterielPedagoAdapte() {
        MaterielPedagoAdapte materielPedagoAdapte = materielPedagoAdapteService.getMaterielPedagoAdapte(1);
        materielPedagoAdapte.setNom("updated");
        MaterielPedagoAdapte materielPedagoAdapteUpdated = materielPedagoAdapteService.updateMaterielPedagoAdapte(materielPedagoAdapte);
        assertEquals("updated", materielPedagoAdapteUpdated.getNom());
    }

    @Test
    public void getMaterielPedagoAdapte() {
        assertEquals("ordinateur", materielPedagoAdapteService.getMaterielPedagoAdapte(1).getNom());
    }

    @Test
    public void getMaterielPedagoAdapteWithIdNotExist() {
        assertNull(materielPedagoAdapteService.getMaterielPedagoAdapte(75));
    }

    @Test
    public void getAllMaterielPedagoAdapte() {
        assertEquals(4, materielPedagoAdapteService.getAllMaterielPedagoAdapte(1).size());
    }
}
