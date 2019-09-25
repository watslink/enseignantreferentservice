package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.Niveau;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaAttributeConverter<Niveau, Integer> {
}
