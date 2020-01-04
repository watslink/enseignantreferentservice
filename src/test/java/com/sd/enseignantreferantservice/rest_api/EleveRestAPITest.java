package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.business.serviceInterface.EleveService;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class EleveRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EleveService eleveService;

    @Test
    public void getEleve() throws Exception  {
        mvc.perform(get("/eleve/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Petit"));
    }

    @Test
    public void getListEleve() throws Exception  {
        mvc.perform(get("/eleves/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(20)));
    }

    @Test
    public void getListEleveInscrits() throws Exception  {
        mvc.perform(get("/eleves/inscrits/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(17)));
    }

    @Test
    public void getListEleveNonInscrits() throws Exception  {
        mvc.perform(get("/eleves/noninscrits/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void getListEleveVus() throws Exception  {
        mvc.perform(get("/eleves/vus/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getListEleveNonVus() throws Exception  {
        mvc.perform(get("/eleves/nonvus/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)));
    }

    @Test
    public void getListEleve10NextRDV() throws Exception  {
        mvc.perform(get("/eleves/nextRDV/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @Rollback
    @Transactional
    public void validateInscription() throws Exception  {
        Eleve eleve= eleveService.getEleve(20);
        mvc.perform(post("/elevevalidate" )
                .content(asJsonString(eleve))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dossierAccepte").value(true));
    }

    @Test
    @Rollback
    @Transactional
    public void addEleve() throws Exception  {
        Eleve eleve = new Eleve();
        eleve.setNom("nom");
        eleve.setPrenom("prenom");
        eleve.setDateNaissance(new Date(2010-10-10));
        EnseignantReferent enseignantReferent = new EnseignantReferent();
        enseignantReferent.setEnseignantReferentId(1);
        eleve.setEnseignantReferent(enseignantReferent);
        mvc.perform(post("/eleve" )
                .content(asJsonString(eleve))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateEleve() throws Exception  {
        Eleve eleve = new Eleve();
        eleve.setNom("nom");
        eleve.setPrenom("prenom");
        eleve.setDateNaissance(new Date(2010-10-10));
        EnseignantReferent enseignantReferent = new EnseignantReferent();
        enseignantReferent.setEnseignantReferentId(1);
        eleve.setEnseignantReferent(enseignantReferent);
        eleve.setEleveId(5);
        mvc.perform(put("/eleve" )
                .content(asJsonString(eleve))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
        mvc.perform(get("/eleve/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteEleve() throws Exception  {
        mvc.perform(delete("/eleve/6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/eleve/6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
