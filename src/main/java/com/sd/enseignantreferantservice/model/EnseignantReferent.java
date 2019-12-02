package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
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
public class EnseignantReferent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enseignantReferentId;

    private String nom;
    private String prenom;
    private String mail;

    private String motDePasse;

    private boolean enabled;

    @JsonIgnore //Pour ne pas recuperer le mot de passe dans la reponse aux requetes REST
    public String getMotDePasse() {
        return motDePasse;
    }

    @JsonSetter //Pour pouvoir modifier le mot de passe via une requete au format json
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<AESH> listAeshs;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Categorie> listCategories;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<DocumentInscriptionRequis> listDocInscRequis;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Etablissement> listEtablissements;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<MaterielPedagoAdapte> listMatPedagoAdaptes;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Niveau> listNiveaux;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<PIAL> listPials;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<StructurePro> listStructPros;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignantReferent",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<RepresentantLegal> listRepresentantsLegaux;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnseignantReferent that = (EnseignantReferent) o;
        return enseignantReferentId == that.enseignantReferentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enseignantReferentId);
    }
}
