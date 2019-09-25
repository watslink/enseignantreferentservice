package com.sd.enseignantreferantservice.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Niveau implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int niveauId;

    private String libelle;

    private int degre;

    private boolean specialise;
}
