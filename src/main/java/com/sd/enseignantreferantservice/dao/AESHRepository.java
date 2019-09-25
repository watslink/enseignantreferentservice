package com.sd.enseignantreferantservice.dao;

import com.sd.enseignantreferantservice.model.AESH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AESHRepository extends JpaRepository<AESH, Integer> {
}
