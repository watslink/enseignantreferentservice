package com.sd.enseignantreferantservice.business.serviceInterface;


import com.sd.enseignantreferantservice.model.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau addNiveau(Niveau niveau);

    void deleteNiveau(int id);

    Niveau updateNiveau(Niveau niveau);

    Niveau getNiveau(int id);

    List<Niveau> getAllNiveau(int ensRefId);
}
