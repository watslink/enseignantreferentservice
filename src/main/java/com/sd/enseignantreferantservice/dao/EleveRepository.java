package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {

    List<Eleve> findByDossierAccepte(boolean bool);

    List<Eleve> findByVu(boolean bool);
}
