package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;

import java.util.List;

public interface DocumentInscriptionRequisService {

    DocumentInscriptionRequis addDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis);
    void deleteDocumentInscriptionRequis (int id);
    DocumentInscriptionRequis updateDocumentInscriptionRequis (DocumentInscriptionRequis documentInscriptionRequis);

    DocumentInscriptionRequis getDocumentInscriptionRequis(int id);

    List<DocumentInscriptionRequis> getAllDocumentInscriptionRequis();
}
