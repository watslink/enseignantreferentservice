package com.sd.enseignantreferantservice.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Niveau {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int niveauId;

    private String libelle;

    private int degre;

    private boolean specialise;
}
