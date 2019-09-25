package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Integer> {
}