package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {
}
