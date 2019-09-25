package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
}
