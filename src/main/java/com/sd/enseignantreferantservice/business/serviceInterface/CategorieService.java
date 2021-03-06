package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie addCategorie(Categorie categorie);

    void deleteCategorie(int id);

    Categorie updateCategorie(Categorie categorie);

    Categorie getCategorie(int id);

    List<Categorie> getAllCategorie(int ensRefId);
}
