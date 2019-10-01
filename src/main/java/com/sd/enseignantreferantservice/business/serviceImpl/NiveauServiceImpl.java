package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.NiveauService;
import com.sd.enseignantreferantservice.dao.NiveauRepository;
import com.sd.enseignantreferantservice.model.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NiveauServiceImpl implements NiveauService {

    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveau addNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public void deleteNiveau(Niveau niveau) {
        niveauRepository.delete(niveau);
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau getNiveau(int id) {
        Optional<Niveau> optionalNiveau=niveauRepository.findById(id);
        return optionalNiveau.orElse(null) ;
    }

    @Override
    public List<Niveau> getAllNiveau() {
        return niveauRepository.findAll();
    }
}
