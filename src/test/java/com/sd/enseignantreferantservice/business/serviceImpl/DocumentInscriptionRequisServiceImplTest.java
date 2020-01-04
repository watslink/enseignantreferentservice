package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
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
public class DocumentInscriptionRequisServiceImplTest {


    @Autowired
    DocumentInscriptionRequisServiceImpl documentInscriptionRequisService;

    @Test
    @Transactional
    @Rollback
    public void addDocumentInscriptionRequis() {
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        DocumentInscriptionRequis documentInscriptionRequis = new DocumentInscriptionRequis();
        documentInscriptionRequis.setEnseignantReferent(ensRef);
        documentInscriptionRequis.setNom("document");
        DocumentInscriptionRequis documentInscriptionRequisAdded = documentInscriptionRequisService.addDocumentInscriptionRequis(documentInscriptionRequis);
        assertEquals("document", documentInscriptionRequisAdded.getNom());
        assertEquals(ensRef, documentInscriptionRequisAdded.getEnseignantReferent());
    }

    @Test
    @Transactional
    @Rollback
    public void deleteDocumentInscriptionRequis() {
        documentInscriptionRequisService.deleteDocumentInscriptionRequis(2);
        assertNull(documentInscriptionRequisService.getDocumentInscriptionRequis(2));
    }

    @Test
    @Transactional
    @Rollback
    public void updateDocumentInscriptionRequis() {
        DocumentInscriptionRequis documentInscriptionRequis = documentInscriptionRequisService.getDocumentInscriptionRequis(2);
        documentInscriptionRequis.setNom("docUpdated");
        DocumentInscriptionRequis documentInscriptionRequisUpdated = documentInscriptionRequisService.updateDocumentInscriptionRequis(documentInscriptionRequis);
        assertEquals("docUpdated", documentInscriptionRequisUpdated.getNom());
    }

    @Test
    public void getDocumentInscriptionRequis() {
        DocumentInscriptionRequis documentInscriptionRequis = documentInscriptionRequisService.getDocumentInscriptionRequis(2);
        assertEquals(2, documentInscriptionRequis.getDocumentInscriptionRequisId());
    }

    @Test
    public void getDocumentInscriptionRequisWithIdNotExist() {
        assertNull(documentInscriptionRequisService.getDocumentInscriptionRequis(75));
    }

    @Test
    public void getAllDocumentInscriptionRequis() {
        assertEquals(2, documentInscriptionRequisService.getAllDocumentInscriptionRequis(1).size());
    }
}
