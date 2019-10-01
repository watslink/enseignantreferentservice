package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.EleveService;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EleveDocumentInscriptionRequis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
public class EleveServiceImpl implements EleveService {

    @Autowired
    EleveRepository eleveRepository;

    @Autowired
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;


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
        eleve.setListEleveDocumentsInscriptionRequis(null);
        eleveRepository.save(eleve);
        return eleve;
    }
}
