package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.RepresentantLegal;

import java.util.List;

public interface RepresentantLegalService {

    RepresentantLegal addRepresentantLegal(RepresentantLegal representantLegal);
    void deleteRepresentantLegal (int id);
    RepresentantLegal updateRepresentantLegal (RepresentantLegal representantLegal);

    RepresentantLegal getRepresentantLegal(int id);

    List<RepresentantLegal> getAllRepresentantLegal();
}
