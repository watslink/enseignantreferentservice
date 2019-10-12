package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.StructureProService;
import com.sd.enseignantreferantservice.dao.StructureProRepository;
import com.sd.enseignantreferantservice.model.StructurePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StructureProServiceImpl implements StructureProService {

    @Autowired
    StructureProRepository structureProRepository;

    @Override
    public StructurePro addStructurePro(StructurePro structurePro) {
        return structureProRepository.save(structurePro);
    }

    @Override
    public void deleteStructurePro(int id) {
        structureProRepository.deleteById(id);
    }

    @Override
    public StructurePro updateStructurePro(StructurePro structurePro) {
        return structureProRepository.save(structurePro);
    }

    @Override
    public StructurePro getStructurePro(int id) {
        Optional<StructurePro> optionalStructurePro=structureProRepository.findById(id);
        return optionalStructurePro.orElse(null) ;
    }

    @Override
    public List<StructurePro> getAllStructurePro() {
        return structureProRepository.findAll(Sort.by("nom"));
    }
}
