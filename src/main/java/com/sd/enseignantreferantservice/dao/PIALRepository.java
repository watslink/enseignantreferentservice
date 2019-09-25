package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.PIAL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PIALRepository  extends JpaRepository<PIAL, Integer> {
}
