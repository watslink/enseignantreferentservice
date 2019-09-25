package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
