package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class EnseignantReferent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enseignantReferentId;

    private String nom;
    private String prenom;
    private String identifiant;

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
}
