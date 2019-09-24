package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class StructurePro implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int structureProId;

    private String nom;
    private String specialite;
    private String telephone;
    private String mail;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;
}
