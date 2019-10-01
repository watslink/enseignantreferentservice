package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.EtablissementService;
import com.sd.enseignantreferantservice.dao.EtablissementRepository;
import com.sd.enseignantreferantservice.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class EtablissementServiceImpl implements EtablissementService {

    @Autowired
    EtablissementRepository etablissementRepository;

    @Override
    public Etablissement addEtablissement(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public void deleteEtablissement(Etablissement etablissement) {
        etablissementRepository.delete(etablissement);
    }

    @Override
    public Etablissement updateEtablissement(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public Etablissement getEtablissement(int id) {
        Optional<Etablissement> optionalEtablissement=etablissementRepository.findById(id);
        return optionalEtablissement.orElse(null) ;
    }

    @Override
    public List<Etablissement> getAllEtablissement() {
        return etablissementRepository.findAll();
    }
}
