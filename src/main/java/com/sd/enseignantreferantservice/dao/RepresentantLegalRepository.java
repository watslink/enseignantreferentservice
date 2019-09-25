package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.RepresentantLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentantLegalRepository extends JpaRepository<RepresentantLegal, Integer> {
}
