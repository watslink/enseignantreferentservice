package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.Categorie;
import com.sd.enseignantreferantservice.model.Document;
import com.sd.enseignantreferantservice.model.Eleve;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceImplTest {

    @Autowired
    DocumentServiceImpl documentService;


    @Test
    @Transactional
    @Rollback
    public void addDocument() {
        Document document = new Document();
        document.setNom("doc");
        document.setExtension("pdf");
        Eleve eleve = new Eleve();
        eleve.setEleveId(1);
        document.setEleve(eleve);
        Categorie categorie = new Categorie();
        categorie.setCategorieId(1);
        document.setCategorie(categorie);
        Document documentAdded = documentService.addDocument(document);
        assertEquals("doc", documentAdded.getNom());
        assertEquals("pdf", documentAdded.getExtension());
        assertEquals(categorie, documentAdded.getCategorie());
        assertEquals(eleve, document.getEleve());
    }
}
