package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.RepresentantLegalService;
import com.sd.enseignantreferantservice.dao.RepresentantLegalRepository;
import com.sd.enseignantreferantservice.model.RepresentantLegal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RepresentantLegalServiceImpl implements RepresentantLegalService {

    @Autowired
    RepresentantLegalRepository representantLegalRepository;

    @Override
    public RepresentantLegal addRepresentantLegal(RepresentantLegal representantLegal) {
        return representantLegalRepository.save(representantLegal);
    }

    @Override
    public void deleteRepresentantLegal(RepresentantLegal representantLegal) {
        representantLegalRepository.delete(representantLegal);
    }

    @Override
    public RepresentantLegal updateRepresentantLegal(RepresentantLegal representantLegal) {
        return representantLegalRepository.save(representantLegal);
    }

    @Override
    public RepresentantLegal getRepresentantLegal(int id) {
        Optional<RepresentantLegal> optionalRepresentantLegal=representantLegalRepository.findById(id);
        return optionalRepresentantLegal.orElse(null) ;
    }

    @Override
    public List<RepresentantLegal> getAllRepresentantLegal() {
        return representantLegalRepository.findAll();
    }
}
