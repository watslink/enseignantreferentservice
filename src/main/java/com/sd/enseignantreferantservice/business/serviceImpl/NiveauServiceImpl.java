package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.NiveauService;
import com.sd.enseignantreferantservice.dao.NiveauRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public void deleteNiveau(int id) {
        Niveau niv = niveauRepository.getOne(id);
        for(Eleve eleve: niv.getListEleve()){
            eleve.setNiveau(null);
        }
        niveauRepository.deleteById(id);
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
    public List<Niveau> getAllNiveau(int ensRefId) {
        return niveauRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNiveauId(ensRefId);
    }
}
