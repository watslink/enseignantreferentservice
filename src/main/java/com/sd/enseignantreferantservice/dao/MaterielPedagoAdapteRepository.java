package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielPedagoAdapteRepository extends JpaRepository<MaterielPedagoAdapte, Integer> {

    List<MaterielPedagoAdapte> findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(int ensRefId);
}
