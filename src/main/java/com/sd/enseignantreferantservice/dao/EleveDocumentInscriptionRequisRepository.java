package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.EleveDocumentInscriptionRequis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveDocumentInscriptionRequisRepository extends JpaRepository<EleveDocumentInscriptionRequis, Integer> {
}
