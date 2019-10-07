package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.StructurePro;

import java.util.List;

public interface StructureProService {

    StructurePro addStructurePro(StructurePro structurePro);
    void deleteStructurePro (int id);
    StructurePro updateStructurePro (StructurePro structurePro);

    StructurePro getStructurePro(int id);

    List<StructurePro> getAllStructurePro();
}
