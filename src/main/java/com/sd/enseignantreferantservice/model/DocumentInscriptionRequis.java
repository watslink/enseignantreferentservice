package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DocumentInscriptionRequis implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentInscriptionRequisId;

    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "documentInscriptionRequis")
    private Set<EleveDocumentInscriptionRequis> listEleveDocumentInscriptionRequis;


    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentInscriptionRequis that = (DocumentInscriptionRequis) o;
        return documentInscriptionRequisId == that.documentInscriptionRequisId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentInscriptionRequisId);
    }
}
