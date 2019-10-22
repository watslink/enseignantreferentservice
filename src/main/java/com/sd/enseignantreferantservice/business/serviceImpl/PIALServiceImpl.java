package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.PIALService;
import com.sd.enseignantreferantservice.dao.PIALRepository;
import com.sd.enseignantreferantservice.model.AESH;
import com.sd.enseignantreferantservice.model.Etablissement;
import com.sd.enseignantreferantservice.model.PIAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PIALServiceImpl implements PIALService {

    @Autowired
    PIALRepository pialRepository;

    @Override
    public PIAL addPial(PIAL pial) {
        return pialRepository.save(pial);
    }

    @Override
    public void deletePial(int id) {
        PIAL pial=pialRepository.getOne(id);
        for ( AESH aesh: pial.getListAESH()){
            aesh.setPial(null);
        }
        for ( Etablissement et: pial.getListEtablissement()){
            et.setPial(null);
        }
        pialRepository.deleteById(id);
    }

    @Override
    public PIAL updatePial(PIAL pial) {
        return pialRepository.save(pial);
    }

    @Override
    public PIAL getPial(int id) {
        Optional<PIAL> optionalPial=pialRepository.findById(id);
        return optionalPial.orElse(null) ;
    }

    @Override
    public List<PIAL> getAllPial(int ensRefId) {
        return pialRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }
}
