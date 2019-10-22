package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {

    List<Etablissement> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);
}
