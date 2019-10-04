package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.EnseignantReferent;

import java.util.List;

public interface EnseignantReferentService {

    EnseignantReferent addEnseignantReferent(EnseignantReferent enseignantReferent);
    void deleteEnseignantReferent (EnseignantReferent enseignantReferent);
    EnseignantReferent updateEnseignantReferent (EnseignantReferent enseignantReferent);

    EnseignantReferent getEnseignantReferentById(int id);
    EnseignantReferent getByMail(String mail);

    List<EnseignantReferent> getAllEnseignantReferent();
}
