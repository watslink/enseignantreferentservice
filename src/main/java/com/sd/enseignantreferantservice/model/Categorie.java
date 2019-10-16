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
public class Categorie implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categorieId;

    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private Set<Document> listDocument;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return categorieId == categorie.categorieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorieId);
    }
}
