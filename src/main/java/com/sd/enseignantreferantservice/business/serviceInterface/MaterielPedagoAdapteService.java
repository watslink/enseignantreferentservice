package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;

import java.util.List;

public interface MaterielPedagoAdapteService {

    MaterielPedagoAdapte addMaterielPedagoAdapte(MaterielPedagoAdapte materielPedagoAdapte);
    void deleteMaterielPedagoAdapte (int id);
    MaterielPedagoAdapte updateMaterielPedagoAdapte (MaterielPedagoAdapte materielPedagoAdapte);

    MaterielPedagoAdapte getMaterielPedagoAdapte(int id);

    List<MaterielPedagoAdapte> getAllMaterielPedagoAdapte(int ensRefId);
}
