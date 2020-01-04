package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.StructureProService;
import com.sd.enseignantreferantservice.dao.EleveStructureProRepository;
import com.sd.enseignantreferantservice.dao.StructureProRepository;
import com.sd.enseignantreferantservice.model.EleveStructurePro;
import com.sd.enseignantreferantservice.model.StructurePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StructureProServiceImpl implements StructureProService {

    @Autowired
    StructureProRepository structureProRepository;

    @Autowired
    EleveStructureProRepository eleveStructureProRepository;

    @Override
    public StructurePro addStructurePro(StructurePro structurePro) {
        return structureProRepository.save(structurePro);
    }

    @Override
    public void deleteStructurePro(int id) {
        List<EleveStructurePro> eleveStructurePros = eleveStructureProRepository.findAll();
        for (EleveStructurePro eleveSP : eleveStructurePros) {
            if (eleveSP.getStructurePro().getStructureProId() == id) {
                eleveStructureProRepository.delete(eleveSP);
            }

        }
        structureProRepository.deleteById(id);
    }

    @Override
    public StructurePro updateStructurePro(StructurePro structurePro) {
        return structureProRepository.save(structurePro);
    }

    @Override
    public StructurePro getStructurePro(int id) {
        Optional<StructurePro> optionalStructurePro = structureProRepository.findById(id);
        return optionalStructurePro.orElse(null);
    }

    @Override
    public List<StructurePro> getAllStructurePro(int ensRefId) {
        return structureProRepository.findAllByEnseignantReferent_EnseignantReferentIdOrderByNom(ensRefId);
    }
}
