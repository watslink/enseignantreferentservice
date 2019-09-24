package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Etablissement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int etablissementId;

    private String nom;

    private String rne;

    private String telephone;

    private String mail;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;
}
