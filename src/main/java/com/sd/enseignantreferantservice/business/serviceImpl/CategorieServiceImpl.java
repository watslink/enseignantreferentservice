package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.CategorieService;
import com.sd.enseignantreferantservice.dao.CategorieRepository;
import com.sd.enseignantreferantservice.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie getCategorie(int id) {
        Optional<Categorie> optionalCategorie=categorieRepository.findById(id);
        return optionalCategorie.orElse(null) ;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll(Sort.by("nom"));
    }
}
