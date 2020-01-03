package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AESH implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aeshId;

    private String nom;

    private String prenom;

    private String mail;

    private String telephone;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @JsonIgnore
    @OneToMany(mappedBy = "aesh")
    private Set<Eleve> listEleve;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AESH aesh = (AESH) o;
        return aeshId == aesh.aeshId;
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(aeshId);
    }
}
