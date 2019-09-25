package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentInscriptionRequisRepository extends JpaRepository<DocumentInscriptionRequis, Integer> {
}
