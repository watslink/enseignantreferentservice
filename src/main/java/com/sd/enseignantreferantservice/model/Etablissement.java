package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Etablissement implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int etablissementId;

    private String nom;

    private String rne;

    private String telephone;

    private String mail;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;

    @JsonIgnore
    @OneToMany(mappedBy = "etablissement")
    private Set<Eleve> listEleve;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etablissement that = (Etablissement) o;
        return etablissementId == that.etablissementId;
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(etablissementId);
    }
}
