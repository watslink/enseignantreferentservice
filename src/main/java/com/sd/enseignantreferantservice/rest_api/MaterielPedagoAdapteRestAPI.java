package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.MaterielPedagoAdapteService;
import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterielPedagoAdapteRestAPI {


    @Autowired
    private MaterielPedagoAdapteService materielPedagoAdapteService;

    @GetMapping("/materielPedagoAdapte/{id}")
    public MaterielPedagoAdapte getMaterielPedagoAdapte(@PathVariable int id){
        return  materielPedagoAdapteService.getMaterielPedagoAdapte(id);
    }

    @GetMapping("/materielPedagoAdaptes")
    public List<MaterielPedagoAdapte> getListMaterielPedagoAdapte() {
        return materielPedagoAdapteService.getAllMaterielPedagoAdapte();
    }


    @PostMapping("/materielPedagoAdapte")
    public MaterielPedagoAdapte addMaterielPedagoAdapte(@RequestBody MaterielPedagoAdapte materielPedagoAdapte){
        return materielPedagoAdapteService.addMaterielPedagoAdapte(materielPedagoAdapte);
    }

    @PutMapping("/materielPedagoAdapte")
    public MaterielPedagoAdapte updateMaterielPedagoAdapte(@RequestBody MaterielPedagoAdapte materielPedagoAdapte){
        return materielPedagoAdapteService.updateMaterielPedagoAdapte(materielPedagoAdapte);
    }

    @DeleteMapping("/materielPedagoAdapte/{id}")
    public void deleteMaterielPedagoAdapte(@PathVariable int id){
        materielPedagoAdapteService.deleteMaterielPedagoAdapte(id);
    }
}


