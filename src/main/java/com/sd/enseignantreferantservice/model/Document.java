package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    private String nom;

    private String lien;

    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;

}
