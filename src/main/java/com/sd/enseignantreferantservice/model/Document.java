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
public class Document implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    private String nom;

    private String extension;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return documentId == document.documentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId);
    }

    public Document(String nom, String extension, Categorie categorie, Eleve eleve) {
        this.nom = nom;
        this.extension = extension;
        this.categorie = categorie;
        this.eleve = eleve;
    }
}
