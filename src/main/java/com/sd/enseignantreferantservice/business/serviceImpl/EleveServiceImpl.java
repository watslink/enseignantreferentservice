package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.dao.*;
import com.sd.enseignantreferantservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class EleveServiceImpl implements EleveService {

    @Autowired
    EleveRepository eleveRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    EleveDocumentInscriptionRequisRepository eleveDocumentInscriptionRequisRepository;


    @Override
    public Eleve addEleve(Eleve eleve) {
        eleve.setDossierAccepte(false);
        eleve.setVu(false);
        Set<RepresentantLegal> representantLegalSet = eleve.getListRepresentantsLegaux();
        Set<EleveStructurePro> eleveStructureProSet = eleve.getListEleveStructurePros();
        eleve.setListEleveStructurePros(null);
        eleve.setListRepresentantsLegaux(null);
        eleve = eleveRepository.save(eleve);

        if (representantLegalSet != null) {
            for (RepresentantLegal representantLegal : representantLegalSet) {
                representantLegal.setEleve(eleve);
            }
        }
        if (eleveStructureProSet != null) {
            for (EleveStructurePro eleveStructurePro : eleveStructureProSet) {
                eleveStructurePro.setEleve(eleve);
                eleveStructurePro.setPk(new EleveStructurePro.PK(eleveStructurePro.getStructurePro().getStructureProId(), eleve.getEleveId()));
            }
        }


        Set<EleveDocumentInscriptionRequis> eleveDocumentInscriptionRequisList = new HashSet<>();

        List<DocumentInscriptionRequis> documentInscriptionRequisList = documentInscriptionRequisRepository.findAll();

        if (documentInscriptionRequisList != null) {
            for (DocumentInscriptionRequis dir : documentInscriptionRequisList) {
                EleveDocumentInscriptionRequis eleveDocumentInscriptionRequis = new EleveDocumentInscriptionRequis();
                eleveDocumentInscriptionRequis.setDocumentInscriptionRequis(dir);
                eleveDocumentInscriptionRequis.setEleve(eleve);
                eleveDocumentInscriptionRequis.setPk(new EleveDocumentInscriptionRequis.PK(dir.getDocumentInscriptionRequisId(), eleve.getEleveId()));
                eleveDocumentInscriptionRequis.setOk(false);
                eleveDocumentInscriptionRequisList.add(eleveDocumentInscriptionRequis);
            }
        }


        eleve.setListRepresentantsLegaux(representantLegalSet);
        eleve.setListEleveStructurePros(eleveStructureProSet);
        eleve.setListEleveDocumentsInscriptionRequis(eleveDocumentInscriptionRequisList);

        eleveRepository.save(eleve);
        return eleve;
    }

    @Override
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }

    @Override
    public Eleve updateEleve(Eleve eleve) {
        if (eleve.getListRepresentantsLegaux() != null) {
            for (RepresentantLegal representantLegal : eleve.getListRepresentantsLegaux()) {
                representantLegal.setEleve(eleve);
            }
        }
        if (eleve.getListEleveStructurePros() != null) {
            for (EleveStructurePro eleveStructurePro : eleve.getListEleveStructurePros()) {
                eleveStructurePro.setEleve(eleve);
                eleveStructurePro.setPk(new EleveStructurePro.PK(eleveStructurePro.getStructurePro().getStructureProId(), eleve.getEleveId()));
            }
        }
        if (eleve.getListDocuments() != null) {
            for (Document document : eleve.getListDocuments()) {
                document.setEleve(eleve);
            }
        }
        eleve = eleveRepository.save(eleve);
        return eleve;
    }

    @Override
    public Eleve getEleve(int id) {
        Optional<Eleve> optionalEleve = eleveRepository.findById(id);
        return optionalEleve.orElse(null);
    }

    @Override
    public List<Eleve> getAllEleve(int ensRefId) {
        return eleveRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }

    @Override
    public List<Eleve> getAllEleveInsciptionEnCours(int ensRefId) {
        return eleveRepository.findByDossierAccepteAndEnseignantReferent_EnseignantReferentIdOrderByNom(false, ensRefId);
    }

    @Override
    public List<Eleve> getAllEleveInscrits(int ensRefId) {
        return eleveRepository.findByDossierAccepteAndEnseignantReferent_EnseignantReferentIdOrderByNom(true, ensRefId);
    }

    @Override
    public List<Eleve> getAllEleveVu(int ensRefId) {
        return eleveRepository.findByDossierAccepteAndVuAndEnseignantReferent_EnseignantReferentIdOrderByNom(true, true, ensRefId);
    }

    @Override
    public List<Eleve> getAllEleveNonVu(int ensRefId) {
        return eleveRepository.findByDossierAccepteAndVuAndEnseignantReferent_EnseignantReferentIdOrderByNom(true, false, ensRefId);
    }

    @Override
    public List<Eleve> getTop10EleveOrderByReunion(int ensRefId) {
        return eleveRepository.findTop10ByEnseignantReferent_EnseignantReferentIdAndDateReunionAfterOrderByDateReunion(ensRefId, new Date());
    }

    @Override
    public Eleve validateInscription(Eleve eleve) {

        Categorie categorie = categorieRepository.getOne(1);
        Set<EleveDocumentInscriptionRequis> eleveDocumentInscriptionRequisList = eleve.getListEleveDocumentsInscriptionRequis();
        for (EleveDocumentInscriptionRequis edir : eleveDocumentInscriptionRequisList) {
            Document document = new Document(edir.getDocumentInscriptionRequis().getNom(), edir.getExtension(), categorie, eleve);
            documentRepository.save(document);
            eleve = eleveRepository.getOne(eleve.getEleveId());

        }
        eleve.getListEleveDocumentsInscriptionRequis().clear();
        for (RepresentantLegal representantLegal : eleve.getListRepresentantsLegaux()) {
            representantLegal.setEleve(eleve);
        }
        for (EleveStructurePro eleveStructurePro : eleve.getListEleveStructurePros()) {
            eleveStructurePro.setEleve(eleve);
            eleveStructurePro.setPk(new EleveStructurePro.PK(eleveStructurePro.getStructurePro().getStructureProId(), eleve.getEleveId()));
        }
        eleve.setDossierAccepte(true);
        eleveRepository.save(eleve);
        return eleve;
    }
}
