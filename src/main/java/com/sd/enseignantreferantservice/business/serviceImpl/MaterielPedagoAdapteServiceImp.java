package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.MaterielPedagoAdapteService;
import com.sd.enseignantreferantservice.dao.MaterielPedagoAdapteRepository;
import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MaterielPedagoAdapteServiceImp implements MaterielPedagoAdapteService {

    @Autowired
    MaterielPedagoAdapteRepository materielPedagoAdapteRepository;

    @Override
    public MaterielPedagoAdapte addMaterielPedagoAdapte(MaterielPedagoAdapte materielPedagoAdapte) {
        return materielPedagoAdapteRepository.save(materielPedagoAdapte);
    }

    @Override
    public void deleteMaterielPedagoAdapte(MaterielPedagoAdapte materielPedagoAdapte) {
        materielPedagoAdapteRepository.delete(materielPedagoAdapte);
    }

    @Override
    public MaterielPedagoAdapte updateMaterielPedagoAdapte(MaterielPedagoAdapte materielPedagoAdapte) {
        return materielPedagoAdapteRepository.save(materielPedagoAdapte);
    }

    @Override
    public MaterielPedagoAdapte getMaterielPedagoAdapte(int id) {
        Optional<MaterielPedagoAdapte> optionalMaterielPedagoAdapte=materielPedagoAdapteRepository.findById(id);
        return optionalMaterielPedagoAdapte.orElse(null) ;
    }

    @Override
    public List<MaterielPedagoAdapte> getAllMaterielPedagoAdapte() {
        return materielPedagoAdapteRepository.findAll();
    }
}
