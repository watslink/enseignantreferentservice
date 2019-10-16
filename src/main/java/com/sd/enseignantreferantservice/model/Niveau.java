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
public class Niveau implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int niveauId;

    private String libelle;

    private Integer degre;

    private boolean specialise;

    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private Set<Eleve> listEleve;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Niveau niveau = (Niveau) o;
        return niveauId == niveau.niveauId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(niveauId);
    }
}
