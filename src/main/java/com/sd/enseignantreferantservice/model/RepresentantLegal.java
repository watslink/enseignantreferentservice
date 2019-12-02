package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RepresentantLegal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int representantLegalId;

    private String identite;

    private String mail;

    private String telephone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "eleve_representant_legal",
            joinColumns = {@JoinColumn(name = "representant_legal_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    private List<Eleve> listEleve;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepresentantLegal that = (RepresentantLegal) o;
        return representantLegalId == that.representantLegalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(representantLegalId);
    }
}

