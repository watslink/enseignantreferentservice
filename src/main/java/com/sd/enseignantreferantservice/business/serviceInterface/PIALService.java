package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.PIAL;

import java.util.List;

public interface PIALService {

    PIAL addPial(PIAL pial);
    void deletePial (PIAL pial);
    PIAL updatePial (PIAL pial);

    PIAL getPial(int id);

    List<PIAL> getAllPial();
}
