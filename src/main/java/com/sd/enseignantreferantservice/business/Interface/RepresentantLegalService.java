package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.RepresentantLegal;

import java.util.List;

public interface RepresentantLegalService {

    RepresentantLegal addRepresentantLegal(RepresentantLegal representantLegal);
    void deleteRepresentantLegal (RepresentantLegal representantLegal);
    RepresentantLegal updateRepresentantLegal (RepresentantLegal representantLegal);

    RepresentantLegal getRepresentantLegal(int id);

    List<RepresentantLegal> getAllRepresentantLegal();
}
