package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Generated;
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
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    private String nom;

    private String extension;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    public Document(String nom, String extension, Categorie categorie, Eleve eleve) {
        this.nom = nom;
        this.extension = extension;
        this.categorie = categorie;
        this.eleve = eleve;
    }

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentId == document.documentId;
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(documentId);
    }
}
