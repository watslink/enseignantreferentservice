package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.DocumentInscriptionRequisService;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveDocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EleveDocumentInscriptionRequis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        documentInscriptionRequisRepository.save(documentInscriptionRequis);

        List<Eleve> elevesNonInscrits=eleveRepository.findByDossierAccepte(false);

        EleveDocumentInscriptionRequis edir =new EleveDocumentInscriptionRequis();
        edir.setDocumentInscriptionRequis(documentInscriptionRequis);
        edir.setOk(false);

        for (Eleve eleve:elevesNonInscrits) {
            edir.setEleve(eleve);
            edirRepo.save(edir);
        }

        return documentInscriptionRequis;
    }

    @Override
    public void deleteDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis) {
        documentInscriptionRequisRepository.delete(documentInscriptionRequis);
    }

    @Override
    public DocumentInscriptionRequis updateDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis) {
        return documentInscriptionRequisRepository.save(documentInscriptionRequis);
    }

    @Override
    public DocumentInscriptionRequis getDocumentInscriptionRequis(int id) {
        Optional<DocumentInscriptionRequis> optionalDocumentInscriptionRequis=documentInscriptionRequisRepository.findById(id);
        return optionalDocumentInscriptionRequis.orElse(null) ;
    }

    @Override
    public List<DocumentInscriptionRequis> getAllDocumentInscriptionRequis() {
        return documentInscriptionRequisRepository.findAll();
    }
}
