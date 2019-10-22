package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentInscriptionRequisRepository extends JpaRepository<DocumentInscriptionRequis, Integer> {
    List<DocumentInscriptionRequis> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);
}
