package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AESH implements Serializable {

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
