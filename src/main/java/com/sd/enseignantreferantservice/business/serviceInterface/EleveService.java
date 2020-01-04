package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.Eleve;

import java.util.List;

public interface EleveService {

    Eleve addEleve(Eleve eleve);

    void deleteEleve(int id);

    Eleve updateEleve(Eleve eleve);

    Eleve getEleve(int id);

    List<Eleve> getAllEleve(int ensRefId);

    List<Eleve> getAllEleveInsciptionEnCours(int ensRefId);

    List<Eleve> getAllEleveInscrits(int ensRefId);

    List<Eleve> getAllEleveVu(int ensRefId);

    List<Eleve> getAllEleveNonVu(int ensRefId);

    List<Eleve> getTop10EleveOrderByReunion(int ensRefId);

    Eleve validateInscription(Eleve eleve);


}
