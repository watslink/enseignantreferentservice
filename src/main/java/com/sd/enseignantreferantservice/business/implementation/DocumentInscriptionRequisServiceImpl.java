package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.DocumentInscriptionRequisService;
import com.sd.enseignantreferantservice.dao.DocumentInscriptionRequisRepository;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DocumentInscriptionRequisServiceImpl implements DocumentInscriptionRequisService {

    @Autowired
    DocumentInscriptionRequisRepository documentInscriptionRequisRepository;

    @Override
    public DocumentInscriptionRequis addDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis) {
        return documentInscriptionRequisRepository.save(documentInscriptionRequis);
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
