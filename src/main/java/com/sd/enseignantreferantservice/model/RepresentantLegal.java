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
    @JoinColumn(name = "enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    @JsonIgnore
    private Eleve eleve;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepresentantLegal that = (RepresentantLegal) o;
        return representantLegalId == that.representantLegalId;
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(representantLegalId);
    }
}

