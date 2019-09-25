package com.sd.enseignantreferantservice;

import com.sd.enseignantreferantservice.dao.EnseignantReferentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnseignantreferantserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EnseignantreferantserviceApplication.class, args);
    }

    @Autowired
    EnseignantReferentRepository enseignantReferentRepository;

    @Override
    public void run(String... args) throws Exception {
        enseignantReferentRepository.findAll().forEach(m->{
            System.out.println(m.toString());
        });
    }
}
