package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EleveServiceImplTest {

    @Autowired
    EleveServiceImpl eleveService;

    @Test
    @Transactional
    @Rollback
    public void addSimpleEleve() {
        Eleve eleveAdded = eleveService.addEleve(initialiseSimpleEleve());
        assertEquals("nom", eleveAdded.getNom());
        assertEquals("prenom", eleveAdded.getPrenom());
        assertEquals(new Date(2010-10-10), eleveAdded.getDateNaissance());
        assertFalse(eleveAdded.isDossierAccepte());
        assertFalse(eleveAdded.isVu());
        assertEquals(2, eleveAdded.getListEleveDocumentsInscriptionRequis().size());
    }

    @Test
    @Transactional
    @Rollback
    public void addCompleteEleve() {
        Eleve eleveAdded = eleveService.addEleve(initialiseCompleteEleve());
        assertEquals(1, eleveAdded.getNiveau().getNiveauId());
        assertEquals(2, eleveAdded.getEtablissement().getEtablissementId());
        assertEquals(3, eleveAdded.getAesh().getAeshId());
        assertEquals(new Date(2020-10-10), eleveAdded.getDateNotificationAesh());
    }

    private Eleve initialiseSimpleEleve(){
        Eleve eleve = new Eleve();
        eleve.setNom("nom");
        eleve.setPrenom("prenom");
        eleve.setDateNaissance(new Date(2010-10-10));
        EnseignantReferent enseignantReferent = new EnseignantReferent();
        enseignantReferent.setEnseignantReferentId(1);
        eleve.setEnseignantReferent(enseignantReferent);
        return eleve;
    }

    private Eleve initialiseCompleteEleve(){
        Eleve eleve = initialiseSimpleEleve();
        Niveau niveau = new Niveau();
        niveau.setNiveauId(1);
        eleve.setNiveau(niveau);
        Etablissement etablissement= new Etablissement();
        etablissement.setEtablissementId(2);
        eleve.setEtablissement(etablissement);
        AESH aesh = new AESH();
        aesh.setAeshId(3);
        eleve.setAesh(aesh);
        eleve.setDateNotificationAesh(new Date(2020-10-10));
        return eleve;
    }

    @Test
    @Transactional
    @Rollback
    public void addEleveWithRepresentsantLegaux() {
        Eleve eleve = initialiseCompleteEleve();
        RepresentantLegal representantLegal = new RepresentantLegal();
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
        eleve.setListRepresentantsLegaux(new HashSet<RepresentantLegal>());
        eleve.getListRepresentantsLegaux().add(representantLegal);
        Eleve eleveAdded = eleveService.addEleve(eleve);
        for(RepresentantLegal representantLegalinList: eleveAdded.getListRepresentantsLegaux()){
            assertEquals(representantLegal.getIdentite(), representantLegalinList.getIdentite());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void addEleveWithStructuresPros() {
        Eleve eleve = initialiseCompleteEleve();
        StructurePro structurePro = new StructurePro();
        structurePro.setStructureProId(1);
        eleve.setListEleveStructurePros(new HashSet<EleveStructurePro>());
        EleveStructurePro eleveStructurePro = new EleveStructurePro();
        eleveStructurePro.setStructurePro(structurePro);
        eleve.getListEleveStructurePros().add(eleveStructurePro);
        Eleve eleveAdded = eleveService.addEleve(eleve);
        for(EleveStructurePro eleveStructureProinList : eleveAdded.getListEleveStructurePros()){
            assertEquals(eleveStructurePro.getStructurePro().getStructureProId(), eleveStructureProinList.getStructurePro().getStructureProId());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void addEleveWithMaterielsPedagos() {
        Eleve eleve = initialiseCompleteEleve();
        MaterielPedagoAdapte materielPedagoAdapte = new MaterielPedagoAdapte();
        materielPedagoAdapte.setMaterielPedagoAdapteId(2);
        eleve.setListMaterielsPedagoAdaptes(new HashSet<MaterielPedagoAdapte>());
        eleve.getListMaterielsPedagoAdaptes().add(materielPedagoAdapte);
        Eleve eleveAdded = eleveService.addEleve(eleve);
        for(MaterielPedagoAdapte materielPedagoAdapteInList : eleveAdded.getListMaterielsPedagoAdaptes()){
            assertEquals(materielPedagoAdapte.getMaterielPedagoAdapteId(), materielPedagoAdapteInList.getMaterielPedagoAdapteId());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void deleteEleve() {
        eleveService.deleteEleve(1);
        assertNull(eleveService.getEleve(1));
    }

    @Test
    @Transactional
    @Rollback
    public void updateEleve() {
        Eleve eleve = eleveService.getEleve(1);
        eleve.setNom("newNom");
        Eleve eleveUpdated = eleveService.updateEleve(eleve);
        assertEquals("newNom", eleveUpdated.getNom());
    }

    @Test
    @Transactional
    @Rollback
    public void updateEleveWithDocument() {
        Eleve eleve = eleveService.getEleve(5);
        Document document = new Document();
        document.setNom("doc");
        document.setExtension("pdf");
        eleve.setListDocuments(new HashSet<Document>());
        eleve.getListDocuments().add(document);
        Eleve eleveUpdated = eleveService.updateEleve(eleve);
        for(Document documentInList : eleveUpdated.getListDocuments()){
            assertEquals(document.getNom(), documentInList.getNom());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void updateEleveWithDateReunion() {
        Eleve eleve = eleveService.getEleve(5);
        eleve.setDateReunion(new Date(2020-12-12));
        Eleve eleveUpdated = eleveService.updateEleve(eleve);
        assertEquals(new Date(2020-12-12), eleveUpdated.getDateReunion());
    }

    @Test
    @Transactional
    @Rollback
    public void updateEleveWithVu() {
        Eleve eleve = eleveService.getEleve(5);
        eleve.setVu(true);
        Eleve eleveUpdated = eleveService.updateEleve(eleve);
        assertTrue(eleveUpdated.isVu());
    }

    @Test
    public void getEleve() {
        Eleve eleve = eleveService.getEleve(6);
        assertEquals(6, eleve.getEleveId());
    }

    @Test
    public void getAllEleve() {
        assertEquals(20, eleveService.getAllEleve(1).size());
    }

    @Test
    public void getAllEleveInsciptionEnCours() {
        assertEquals(3, eleveService.getAllEleveInsciptionEnCours(1).size());
    }

    @Test
    public void getAllEleveInscrits() {
        assertEquals(17, eleveService.getAllEleveInscrits(1).size());
    }

    @Test
    public void getAllEleveNonVu() {
        assertEquals(15, eleveService.getAllEleveNonVu(1).size());
    }

    @Test
    public void getAllEleveVu() {
        assertEquals(2, eleveService.getAllEleveVu(1).size());
    }

    @Test
    public void getTop10EleveOrderByReunion() {
        for (Eleve eleve: eleveService.getTop10EleveOrderByReunion(1)) {
            assertNotNull(eleve.getDateReunion());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void validateInscription() {
//        Eleve eleve = eleveService.getEleve(19);
//        Eleve eleveValidated = eleveService.validateInscription(eleve);
//        assertTrue(eleveValidated.isDossierAccepte());
//        assertEquals(0, eleveValidated.getListEleveDocumentsInscriptionRequis().size());
//        assertEquals(2, eleve.getListDocuments().size());
    }
}
