package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Document implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    private String nom;

    private String lien;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;
}
