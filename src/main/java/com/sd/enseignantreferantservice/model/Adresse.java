package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Adresse implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int adresseId;

    private int numero;

    private String voie;

    private String ville;

    private int codePostal;
}
