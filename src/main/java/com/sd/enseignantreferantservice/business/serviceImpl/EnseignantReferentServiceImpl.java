package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.EnseignantReferentService;
import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public void deleteEnseignantReferent(int id) {
        enseignantReferentRepository.deleteById(id);
    }

    @Override
    public EnseignantReferent updateMailOfEnseignantReferent(int id, String newMail) {
        EnseignantReferent enseignantReferent = enseignantReferentRepository.getOne(id);
        enseignantReferent.setMail(newMail);
        return enseignantReferentRepository.save(enseignantReferent);
    }

    @Override
    public Boolean updatePasswordOfEnseignantReferent(int id, String oldPass, String newPass) {
        EnseignantReferent enseignantReferent = enseignantReferentRepository.getOne(id);
        if (encoder.matches(oldPass, enseignantReferent.getMotDePasse())) {
            enseignantReferent.setMotDePasse(encoder.encode(newPass));
            enseignantReferentRepository.save(enseignantReferent);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public EnseignantReferent getByMail(String mail) {
        return enseignantReferentRepository.findByMail(mail);
    }

    @Override
    public EnseignantReferent getEnseignantReferentById(int id) {
        Optional<EnseignantReferent> optionalEnseignantReferent = enseignantReferentRepository.findById(id);
        return optionalEnseignantReferent.orElse(null);
    }

    @Override
    public List<EnseignantReferent> getAllEnseignantReferent() {
        return enseignantReferentRepository.findAll(Sort.by("nom"));
    }

    @Override
    public void reinitializeAllRDV(int id) {
        EnseignantReferent enseignantReferent = enseignantReferentRepository.getOne(id);
        for (Eleve eleve : enseignantReferent.getListEleves()) {
            eleve.setDateReunion(null);
            eleve.setVu(false);
        }
        enseignantReferentRepository.save(enseignantReferent);
    }
}
