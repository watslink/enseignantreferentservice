package com.sd.enseignantreferantservice.dao;


import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantReferentRepository extends JpaRepository<EnseignantReferent, Integer> {

    EnseignantReferent findByIdentifiant(String identifiant);
}
