package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EtablissementService;
import com.sd.enseignantreferantservice.dao.EtablissementRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.Etablissement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EtablissementServiceImpl implements EtablissementService {

    @Autowired
    EtablissementRepository etablissementRepository;

    @Override
    public Etablissement addEtablissement(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public void deleteEtablissement(int id) {
        Etablissement et = etablissementRepository.getOne(id);
        for (Eleve eleve : et.getListEleve()) {
            eleve.setEtablissement(null);
        }
        etablissementRepository.deleteById(id);
    }

    @Override
    public Etablissement updateEtablissement(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public Etablissement getEtablissement(int id) {
        Optional<Etablissement> optionalEtablissement = etablissementRepository.findById(id);
        return optionalEtablissement.orElse(null);
    }

    @Override
    public List<Etablissement> getAllEtablissement(int ensRefId) {
        return etablissementRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }
}
