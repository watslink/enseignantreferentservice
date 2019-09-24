package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class DocumentRequis {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentRequisId;

    private String nom;
}
