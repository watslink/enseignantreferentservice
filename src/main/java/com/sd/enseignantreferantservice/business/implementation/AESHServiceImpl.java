package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.AESHService;
import com.sd.enseignantreferantservice.dao.AESHRepository;
import com.sd.enseignantreferantservice.model.AESH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class AESHServiceImpl implements AESHService {

    @Autowired
    AESHRepository aeshRepository;

    @Override
    public AESH addAESH(AESH aesh) {
        return aeshRepository.save(aesh);
    }

    @Override
    public void deleteAesh(AESH aesh) {
        aeshRepository.delete(aesh);
    }

    @Override
    public AESH updateAesh(AESH aesh) {
        return aeshRepository.save(aesh);
    }

    @Override
    public AESH getAesh(int id) {
        Optional<AESH> optionalAESH=aeshRepository.findById(id);
        return optionalAESH.orElse(null) ;
    }

    @Override
    public List<AESH> getAllAesh() {
        return aeshRepository.findAll();
    }
}
