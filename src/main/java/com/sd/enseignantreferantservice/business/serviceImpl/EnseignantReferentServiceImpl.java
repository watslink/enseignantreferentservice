package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EnseignantReferentService;
import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnseignantReferentServiceImpl implements EnseignantReferentService {

    @Autowired
    EnseignantReferentRepository enseignantReferentRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public EnseignantReferent addEnseignantReferent(EnseignantReferent enseignantReferent) {
        enseignantReferent.setMotDePasse(encoder.encode(enseignantReferent.getMotDePasse()));
        enseignantReferent.setEnabled(true);
        return enseignantReferentRepository.save(enseignantReferent);
    }

    @Override
    public void deleteEnseignantReferent(EnseignantReferent enseignantReferent) {
        enseignantReferentRepository.delete(enseignantReferent);
    }

    @Override
    public EnseignantReferent updateEnseignantReferent(EnseignantReferent enseignantReferent) {
        enseignantReferent.setMotDePasse(encoder.encode(enseignantReferent.getMotDePasse()));
        return enseignantReferentRepository.save(enseignantReferent);
    }

    @Override
    public EnseignantReferent getByMail(String mail) {
        return enseignantReferentRepository.findByMail(mail);
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
