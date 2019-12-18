package com.sd.enseignantreferantservice;

import com.sd.enseignantreferantservice.dao.EleveRepository;
import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import com.sd.enseignantreferantservice.dao.MaterielPedagoAdapteRepository;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Autowired
    MaterielPedagoAdapteRepository materielPedagoAdapteRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       java.util.Optional<Eleve> optEleve=eleveRepository.findById(1);
       Eleve eleve=  optEleve.get();
       System.out.println(eleve.toString());
        System.out.println(eleve.toString());
        System.out.println(eleve.getNom());
        System.out.println(eleve.getPrenom());
        System.out.println(eleve.getDateNaissance());
        System.out.println(eleve.getNiveau());
        System.out.println(eleve.getDateReunion());

    }
}
