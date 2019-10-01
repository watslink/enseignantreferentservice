package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;

import java.util.List;

public interface MaterielPedagoAdapteService {

    MaterielPedagoAdapte addMaterielPedagoAdapte(MaterielPedagoAdapte materielPedagoAdapte);
    void deleteMaterielPedagoAdapte (MaterielPedagoAdapte materielPedagoAdapte);
    MaterielPedagoAdapte updateMaterielPedagoAdapte (MaterielPedagoAdapte materielPedagoAdapte);

    MaterielPedagoAdapte getMaterielPedagoAdapte(int id);

    List<MaterielPedagoAdapte> getAllMaterielPedagoAdapte();
}
