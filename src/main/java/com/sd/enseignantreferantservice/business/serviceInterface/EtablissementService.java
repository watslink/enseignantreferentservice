package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.Etablissement;

import java.util.List;

public interface EtablissementService {

    Etablissement addEtablissement(Etablissement etablissement);
    void deleteEtablissement (int id);
    Etablissement updateEtablissement (Etablissement etablissement);

    Etablissement getEtablissement(int id);

    List<Etablissement> getAllEtablissement(int ensRefId);
}
