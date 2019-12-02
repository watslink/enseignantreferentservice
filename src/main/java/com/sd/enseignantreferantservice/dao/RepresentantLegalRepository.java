package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.RepresentantLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepresentantLegalRepository extends JpaRepository<RepresentantLegal, Integer> {

    List<RepresentantLegal> findAllByEnseignantReferent_EnseignantReferentIdOrderByIdentite(int ensRefId);
}
