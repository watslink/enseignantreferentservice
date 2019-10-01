package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;

import java.util.List;

public interface DocumentInscriptionRequisService {

    DocumentInscriptionRequis addDocumentInscriptionRequis(DocumentInscriptionRequis documentInscriptionRequis);
    void deleteDocumentInscriptionRequis (DocumentInscriptionRequis documentInscriptionRequis);
    DocumentInscriptionRequis updateDocumentInscriptionRequis (DocumentInscriptionRequis documentInscriptionRequis);

    DocumentInscriptionRequis getDocumentInscriptionRequis(int id);

    List<DocumentInscriptionRequis> getAllDocumentInscriptionRequis();
}
