package com.sd.enseignantreferantservice.business.Interface;


import com.sd.enseignantreferantservice.model.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau addNiveau(Niveau niveau);
    void deleteNiveau (Niveau niveau);
    Niveau updateNiveau (Niveau niveau);

    Niveau getNiveau(int id);

    List<Niveau> getAllNiveau();
}
