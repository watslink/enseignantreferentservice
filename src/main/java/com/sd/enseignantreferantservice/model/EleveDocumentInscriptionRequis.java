package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(EleveDocumentInscriptionRequis.class)
public class EleveDocumentInscriptionRequis implements Serializable {



    @Id
    @ManyToOne
    @JoinColumn(name="document_inscription_requis_id")
    private DocumentInscriptionRequis documentInscriptionRequis;

    @Id
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;


    private String lien;

    private boolean ok;
}
