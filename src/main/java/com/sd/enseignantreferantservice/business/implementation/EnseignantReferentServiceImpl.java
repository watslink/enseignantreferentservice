package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.EnseignantReferentService;
import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnseignantReferentServiceImpl implements EnseignantReferentService {

    @Autowired
    EnseignantReferentRepository enseignantReferentRepository;

    @Override
    public EnseignantReferent addEnseignantReferent(EnseignantReferent enseignantReferent) {
        return enseignantReferentRepository.save(enseignantReferent);
    }

    @Override
    public void deleteEnseignantReferent(EnseignantReferent enseignantReferent) {
        enseignantReferentRepository.delete(enseignantReferent);
    }

    @Override
    public EnseignantReferent updateEnseignantReferent(EnseignantReferent enseignantReferent) {
        return enseignantReferentRepository.save(enseignantReferent);
    }

    @Override
    public EnseignantReferent getByIdentifiant(String identifiant) {
        return enseignantReferentRepository.findByIdentifiant(identifiant);
    }

    @Override
    public EnseignantReferent getEnseignantReferentById(int id) {
        Optional<EnseignantReferent> optionalEnseignantReferent=enseignantReferentRepository.findById(id);
        return optionalEnseignantReferent.orElse(null) ;
    }

    @Override
    public List<EnseignantReferent> getAllEnseignantReferent() {
        return enseignantReferentRepository.findAll();
    }
}
