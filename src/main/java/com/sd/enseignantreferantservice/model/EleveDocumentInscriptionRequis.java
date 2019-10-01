package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(EleveDocumentInscriptionRequis.class)
public class EleveDocumentInscriptionRequis implements Serializable {



    @Id
    @ManyToOne
    @JoinColumn(name="document_inscription_requis_id")
    private DocumentInscriptionRequis documentInscriptionRequis;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;


    private String lien;

    private boolean ok;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleveDocumentInscriptionRequis that = (EleveDocumentInscriptionRequis) o;
        return documentInscriptionRequis.equals(that.documentInscriptionRequis) &&
                eleve.equals(that.eleve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentInscriptionRequis, eleve);
    }
}
