package com.sd.enseignantreferantservice.business;

import com.sd.enseignantreferantservice.model.Eleve;

import java.util.Set;

public interface EleveService {

    Eleve addEleve(Eleve eleve);
    void deleteEleve (Eleve eleve);
    Eleve updateEleve (Eleve eleve);

    Eleve getEleve(int id);

    Set<Eleve> getAllEleve();

    Set<Eleve> getAllEleveInsciptionEnCours();

    Set<Eleve> getAllEleveInscrits();




}
