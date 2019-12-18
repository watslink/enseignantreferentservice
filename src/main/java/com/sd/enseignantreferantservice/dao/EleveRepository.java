package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {

    List<Eleve> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);

    List<Eleve> findByDossierAccepteAndEnseignantReferent_EnseignantReferentIdOrderByNom(boolean bool, int ensRefId);

    List<Eleve> findByDossierAccepteAndVuAndEnseignantReferent_EnseignantReferentIdOrderByNom(boolean accept, boolean bool, int ensRefId);

    List<Eleve> findTop10ByEnseignantReferent_EnseignantReferentIdAndDateReunionAfterOrderByDateReunion(int ensRefId , Date date);
}
