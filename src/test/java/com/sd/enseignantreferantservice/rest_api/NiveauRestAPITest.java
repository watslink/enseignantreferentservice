package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.Adresse;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.Niveau;
import com.sd.enseignantreferantservice.model.PIAL;
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
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class NiveauRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getNiveau() throws Exception  {
        mvc.perform(get("/niveau/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.libelle").value("TPS"));
    }

    @Test
    public void getListNiveau() throws Exception  {
        mvc.perform(get("/niveaux/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(23)));
    }

    @Test
    @Rollback
    @Transactional
    public void addNiveau() throws Exception  {
        Niveau niveau = new Niveau();
        niveau.setDegre(1);
        niveau.setLibelle("nouveau");
        niveau.setSpecialise(false);
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        niveau.setEnseignantReferent(ensRef);
        mvc.perform(post("/niveau" )
                .content(asJsonString(niveau))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.libelle").value("nouveau"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateNiveau() throws Exception  {
        Niveau niveau = new Niveau();
        niveau.setDegre(1);
        niveau.setLibelle("nouveau");
        niveau.setSpecialise(false);
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        niveau.setEnseignantReferent(ensRef);
        niveau.setNiveauId(1);
        mvc.perform(put("/niveau" )
                .content(asJsonString(niveau))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.libelle").value("nouveau"));
        mvc.perform(get("/niveau/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.libelle").value("nouveau"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteNiveau() throws Exception  {
        mvc.perform(delete("/niveau/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/niveau/2")
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
