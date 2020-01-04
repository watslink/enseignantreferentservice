package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.AESHService;
import com.sd.enseignantreferantservice.dao.AESHRepository;
import com.sd.enseignantreferantservice.model.AESH;
import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AESHServiceImpl implements AESHService {

    @Autowired
    AESHRepository aeshRepository;

    @Override
    public AESH addAesh(AESH aesh) {
        return aeshRepository.save(aesh);
    }

    @Override
    public void deleteAesh(int id) {
        AESH aesh = aeshRepository.getOne(id);
        for (Eleve eleve : aesh.getListEleve()) {
            eleve.setAesh(null);
        }
        aeshRepository.deleteById(id);
    }

    @Override
    public AESH updateAesh(AESH aesh) {
        return aeshRepository.save(aesh);
    }

    @Override
    public AESH getAesh(int id) {
        Optional<AESH> optionalAESH = aeshRepository.findById(id);
        return optionalAESH.orElse(null);
    }

    @Override
    public List<AESH> getAllAesh(int ensRefId) {
        return aeshRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }
}
