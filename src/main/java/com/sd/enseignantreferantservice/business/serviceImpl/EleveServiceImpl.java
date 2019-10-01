package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.dao.CategorieRepository;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveRepository;
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
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;

    @Autowired
    CategorieRepository categorieRepository;


    @Override
    public Eleve addEleve(Eleve eleve) {
        eleve.setDossierAccepte(false);
        Set<EleveDocumentInscriptionRequis> eleveDocumentInscriptionRequisList = new HashSet<>();

        List<DocumentInscriptionRequis> documentInscriptionRequisList=documentInscriptionRequisRepository.findAll();

        for (DocumentInscriptionRequis dir: documentInscriptionRequisList) {
            EleveDocumentInscriptionRequis eleveDocumentInscriptionRequis=new EleveDocumentInscriptionRequis();
            eleveDocumentInscriptionRequis.setDocumentInscriptionRequis(dir);
            eleveDocumentInscriptionRequis.setEleve(eleve);
            eleveDocumentInscriptionRequis.setOk(false);
            eleveDocumentInscriptionRequisList.add(eleveDocumentInscriptionRequis);
        }

        eleve.setListEleveDocumentsInscriptionRequis(eleveDocumentInscriptionRequisList);

        eleveRepository.save(eleve);
        return eleve;
    }

    @Override
    public void deleteEleve(Eleve eleve) {
        eleveRepository.delete(eleve);
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
    public List<Eleve> getAllEleve() {
        return eleveRepository.findAll();
    }

    @Override
    public List<Eleve> getAllEleveInsciptionEnCours() {
        return eleveRepository.findByDossierAccepte(false);
    }

    @Override
    public List<Eleve> getAllEleveInscrits() {
        return eleveRepository.findByDossierAccepte(true);
    }

    @Override
    public List<Eleve> getAllEleveVu() {
        return eleveRepository.findByVu(true);
    }

    @Override
    public List<Eleve> getAllEleveNonVu() {
        return eleveRepository.findByVu(false);
    }

    @Override
    public Eleve validateInscription(Eleve eleve) {
        eleve.setDossierAccepte(true);
        Categorie categorie=categorieRepository.getOne(1);
        Set<Document> listDocuments=new HashSet<>();
        Document document=new Document();
        document.setCategorie(categorie);
        document.setEleve(eleve);
        for (EleveDocumentInscriptionRequis edir:eleve.getListEleveDocumentsInscriptionRequis()){
           document.setNom(edir.getDocumentInscriptionRequis().getNom());
           document.setLien(edir.getLien());
           listDocuments.add(document);
        }
        eleve.setListDocuments(listDocuments);
        eleve.setListEleveDocumentsInscriptionRequis(null);
        eleveRepository.save(eleve);
        return eleve;
    }
}