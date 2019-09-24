package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AESH {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aeshId;

    private String nom;

    private String prenom;

    private String mail;

    private String telephone;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;
}
