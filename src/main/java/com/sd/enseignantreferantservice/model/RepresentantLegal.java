package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RepresentantLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int representantLegalId;

    private String identite;

    private String mail;

    private String telephone;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
}

