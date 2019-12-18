package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.dao.CategorieRepository;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveDocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class EleveServiceImpl implements EleveService {

    @Autowired
    EleveRepository eleveRepository;

    @Autowired
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    EleveDocumentInscriptionRequisRepository eleveDocumentInscriptionRequisRepository;


    @Override
    public Eleve addEleve(Eleve eleve) {
        eleve.setDossierAccepte(false);
        eleve = eleveRepository.save(eleve);
        Set<EleveDocumentInscriptionRequis> eleveDocumentInscriptionRequisList = new HashSet<>();

        List<DocumentInscriptionRequis> documentInscriptionRequisList=documentInscriptionRequisRepository.findAll();

        for (DocumentInscriptionRequis dir: documentInscriptionRequisList) {
            EleveDocumentInscriptionRequis eleveDocumentInscriptionRequis=new EleveDocumentInscriptionRequis();
            eleveDocumentInscriptionRequis.setDocumentInscriptionRequis(dir);
            eleveDocumentInscriptionRequis.setEleve(eleve);
            eleveDocumentInscriptionRequis.setPk(new EleveDocumentInscriptionRequis.PK(dir.getDocumentInscriptionRequisId(), eleve.getEleveId()));
            eleveDocumentInscriptionRequis.setOk(false);
            eleveDocumentInscriptionRequisList.add(eleveDocumentInscriptionRequis);
        }

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
        eleveRepository.save(eleve);
        return eleve;
    }

    @Override
    public Eleve getEleve(int id) {
        Optional<Eleve> optionalEleve=eleveRepository.findById(id);
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
        return eleveRepository.findByDossierAccepteAndVuAndEnseignantReferent_EnseignantReferentIdOrderByNom(true,true, ensRefId);
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
        eleve.setDossierAccepte(true);
        Categorie categorie=categorieRepository.getOne(1);
        for (EleveDocumentInscriptionRequis edir:eleve.getListEleveDocumentsInscriptionRequis()){
          eleve.getListDocuments().add(new Document(edir.getDocumentInscriptionRequis().getNom(), edir.getExtension(), categorie, eleve));
          eleveRepository.save(eleve);
          eleve=eleveRepository.getOne(eleve.getEleveId());
        }
        eleve.getListEleveDocumentsInscriptionRequis().clear();
        eleveRepository.save(eleve);
        return eleve;
    }
}
