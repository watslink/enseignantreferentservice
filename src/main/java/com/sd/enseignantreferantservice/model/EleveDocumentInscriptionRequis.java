package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@IdClass(EleveDocumentInscriptionRequis.class)
public class EleveDocumentInscriptionRequis {

    @Id
    private int eleveId;
    @Id
    private int documentInscriptionRequisId;

    @ManyToOne
    @JoinColumn(name="document_inscription_requis_id")
    private DocumentInscriptionRequis documentInscriptionRequis;

    private String lien;

    private boolean ok;
}
