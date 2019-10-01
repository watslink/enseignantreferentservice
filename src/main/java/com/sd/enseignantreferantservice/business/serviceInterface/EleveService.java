package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.Eleve;

import java.util.List;

public interface EleveService {

    Eleve addEleve(Eleve eleve);
    void deleteEleve (Eleve eleve);
    Eleve updateEleve (Eleve eleve);

    Eleve getEleve(int id);

    List<Eleve> getAllEleve();

    List<Eleve> getAllEleveInsciptionEnCours();

    List<Eleve> getAllEleveInscrits();

    List<Eleve> getAllEleveVu();

    List<Eleve> getAllEleveNonVu();

    Eleve validateInscription(Eleve eleve);




}
