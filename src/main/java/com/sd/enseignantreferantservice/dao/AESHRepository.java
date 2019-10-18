package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.AESH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AESHRepository extends JpaRepository<AESH, Integer> {

    List<AESH> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);
}
