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
public class PIAL implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pialId;

    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "pial")
    private Set<Etablissement> listEtablissement;

    @JsonIgnore
    @OneToMany(mappedBy = "pial")
    private Set<AESH> listAESH;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PIAL pial = (PIAL) o;
        return pialId == pial.pialId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pialId);
    }
}
