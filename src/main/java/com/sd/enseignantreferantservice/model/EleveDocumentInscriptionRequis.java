package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EleveDocumentInscriptionRequis implements Serializable {

    @EmbeddedId
    private PK pk;
    @MapsId("documentInscriptionRequis")
    @ManyToOne
    @JoinColumn(name = "document_inscription_requis_id")
    private DocumentInscriptionRequis documentInscriptionRequis;
    @JsonIgnore
    @MapsId("eleve")
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;
    private String extension;
    private boolean ok;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleveDocumentInscriptionRequis that = (EleveDocumentInscriptionRequis) o;
        return documentInscriptionRequis.equals(that.documentInscriptionRequis) &&
                eleve.equals(that.eleve);
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(documentInscriptionRequis, eleve);
    }

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK implements Serializable {
        private Integer documentInscriptionRequis;

        private Integer eleve;
    }
}

