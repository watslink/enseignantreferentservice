package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.PIALService;
import com.sd.enseignantreferantservice.dao.PIALRepository;
import com.sd.enseignantreferantservice.model.PIAL;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void deletePial(PIAL pial) {
        pialRepository.delete(pial);
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
    public List<PIAL> getAllPial() {
        return pialRepository.findAll();
    }
}
