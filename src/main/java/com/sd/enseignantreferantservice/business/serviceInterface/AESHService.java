package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.AESH;

import java.util.List;

public interface AESHService {

    AESH addAesh(AESH aesh);
    void deleteAesh (int id);
    AESH updateAesh (AESH aesh);

    AESH getAesh(int id);

    List<AESH> getAllAesh();
}
