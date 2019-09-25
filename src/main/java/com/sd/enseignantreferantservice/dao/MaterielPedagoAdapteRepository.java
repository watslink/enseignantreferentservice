package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielPedagoAdapteRepository extends JpaRepository<MaterielPedagoAdapte, Integer> {
}
