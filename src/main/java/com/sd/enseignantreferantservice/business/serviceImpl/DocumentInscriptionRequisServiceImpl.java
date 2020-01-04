package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.DocumentInscriptionRequisService;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveDocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EleveDocumentInscriptionRequis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentInscriptionRequisServiceImpl implements DocumentInscriptionRequisService {

    @Autowired
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;

    @Autowired
    EleveDocumentInscriptionRequisRepository edirRepo;

    @Autowired
    EleveRepository eleveRepository;

    @Override
    public DocumentInscriptionRequis addDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis) {
        DocumentInscriptionRequis documentInscriptionRequisEnr = documentInscriptionRequisRepository.save(documentInscriptionRequis);

        List<Eleve> elevesNonInscrits = eleveRepository
                .findByDossierAccepteAndEnseignantReferent_EnseignantReferentIdOrderByNom(false,
                        documentInscriptionRequis.getEnseignantReferent().getEnseignantReferentId());

        EleveDocumentInscriptionRequis edir = new EleveDocumentInscriptionRequis();
        edir.setDocumentInscriptionRequis(documentInscriptionRequis);
        edir.setOk(false);

        for (Eleve eleve : elevesNonInscrits) {
            edir.setEleve(eleve);
            edir.setPk(new EleveDocumentInscriptionRequis.PK(documentInscriptionRequisEnr.getDocumentInscriptionRequisId(), eleve.getEleveId()));
            edirRepo.save(edir);
        }

        return documentInscriptionRequis;
    }

    @Override
    public void deleteDocumentInscriptionRequis(int id) {
        for (EleveDocumentInscriptionRequis edir : edirRepo.findAll()) {
            if (edir.getDocumentInscriptionRequis().getDocumentInscriptionRequisId() == id) {
                edirRepo.delete(edir);
            }
        }
        documentInscriptionRequisRepository.deleteById(id);
    }

    @Override
    public DocumentInscriptionRequis updateDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis) {
        return documentInscriptionRequisRepository.save(documentInscriptionRequis);
    }

    @Override
    public DocumentInscriptionRequis getDocumentInscriptionRequis(int id) {
        Optional<DocumentInscriptionRequis> optionalDocumentInscriptionRequis = documentInscriptionRequisRepository.findById(id);
        return optionalDocumentInscriptionRequis.orElse(null);
    }

    @Override
    public List<DocumentInscriptionRequis> getAllDocumentInscriptionRequis(int ensRefId) {
        return documentInscriptionRequisRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }
}
