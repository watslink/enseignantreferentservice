package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.EleveStructurePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveStructureProRepository extends JpaRepository<EleveStructurePro, Integer> {
}
