package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.StructurePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureProRepository extends JpaRepository<StructurePro, Integer> {
}
