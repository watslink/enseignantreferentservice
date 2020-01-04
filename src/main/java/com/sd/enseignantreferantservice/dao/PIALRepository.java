package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.PIAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PIALRepository extends JpaRepository<PIAL, Integer> {

    List<PIAL> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);
}
