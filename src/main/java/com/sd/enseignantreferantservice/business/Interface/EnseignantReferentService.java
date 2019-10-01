package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.EnseignantReferent;

import java.util.List;

public interface EnseignantReferentService {

    EnseignantReferent addEnseignantReferent(EnseignantReferent enseignantReferent);
    void deleteEnseignantReferent (EnseignantReferent enseignantReferent);
    EnseignantReferent updateEnseignantReferent (EnseignantReferent enseignantReferent);

    EnseignantReferent getEnseignantReferentById(int id);
    EnseignantReferent getByIdentifiant(String identifiant);

    List<EnseignantReferent> getAllEnseignantReferent();
}
