package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.AESH;

import java.util.List;

public interface AESHService {

    AESH addAESH(AESH aesh);
    void deleteAesh (AESH aesh);
    AESH updateAesh (AESH aesh);

    AESH getAesh(int id);

    List<AESH> getAllAesh();
}
