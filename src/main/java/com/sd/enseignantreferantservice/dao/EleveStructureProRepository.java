package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.EleveStructurePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveStructureProRepository extends JpaRepository<EleveStructurePro, Integer> {


    List<EleveStructurePro> deleteAllByStructurePro_StructureProId(int id);
}
