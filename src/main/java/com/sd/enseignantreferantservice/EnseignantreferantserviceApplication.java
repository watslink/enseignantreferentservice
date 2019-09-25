package com.sd.enseignantreferantservice;

import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Optional;

@SpringBootApplication
public class EnseignantreferantserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EnseignantreferantserviceApplication.class, args);
    }

    @Autowired
    EnseignantReferentRepository enseignantReferentRepository;

    @Autowired
    EleveRepository eleveRepository;

    @Override
    public void run(String... args) throws Exception {
       java.util.Optional<Eleve> optEleve=eleveRepository.findById(2);
       Eleve eleve=  optEleve.get();
       System.out.println(eleve.toString());
        System.out.println(eleve.toString());
        System.out.println(eleve.getNom());
        System.out.println(eleve.getPrenom());
        System.out.println(eleve.getDateNaissance());
        System.out.println(eleve.getNiveau());
        System.out.println(eleve.getEtablissement().getNom());
        System.out.println(eleve.getAesh().getNom());
        System.out.println(eleve.getDateReunion());
        System.out.println(eleve.getDateNotificationAesh());
        System.out.println(eleve.getEnseignantReferent().getIdentifiant());
        System.out.println(eleve.getListRepresentantsLegaux().iterator().next().getIdentite());
        System.out.println(eleve.getListDocuments().iterator().next().getNom());
        System.out.println(eleve.getListMaterielsPedagoAdaptes().iterator().next().getNom());
        System.out.println(eleve.getListStructurePros().iterator().next().getNom());
    }
}
