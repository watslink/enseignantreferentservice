package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.Adresse;
import com.sd.enseignantreferantservice.model.Eleve;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.RepresentantLegal;
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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class RepresentantLegalRestAPITest {

    @Autowired
    private MockMvc mvc;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getRepresentantLegal() throws Exception {
        mvc.perform(get("/representantLegal/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identite").value("Duval Agathe"));
    }

    @Test
    public void getListRepresentantLegal() throws Exception {
        mvc.perform(get("/representantsLegaux/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(19)));
    }

    @Test
    @Rollback
    @Transactional
    public void updateRepresentantLegal() throws Exception {
        RepresentantLegal representantLegal = new RepresentantLegal();
        Eleve eleve = new Eleve();
        eleve.setEleveId(1);
        representantLegal.setEleve(eleve);
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        representantLegal.setEnseignantReferent(ensRef);
        representantLegal.setMail("mail@mail.com");
        representantLegal.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        representantLegal.setAdresse(adresse);
        representantLegal.setIdentite("identite");
        representantLegal.setRepresentantLegalId(1);
        mvc.perform(put("/representantLegal")
                .content(asJsonString(representantLegal))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identite").value("identite"));
        mvc.perform(get("/representantLegal/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.identite").value("identite"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteRepresentantLegal() throws Exception {
        mvc.perform(delete("/representantLegal/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/representantLegal/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
