package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.Adresse;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.StructurePro;
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
public class StructureProRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getStructurePro() throws Exception  {
        mvc.perform(get("/structurePro/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Chatelain"));
    }

    @Test
    public void getListStructurePro() throws Exception  {
        mvc.perform(get("/structurePros/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));
    }

    @Test
    @Rollback
    @Transactional
    public void addStructurePro() throws Exception  {
        StructurePro structurePro = new StructurePro();
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        structurePro.setEnseignantReferent(ensRef);
        structurePro.setMail("mail@mail.com");
        structurePro.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        structurePro.setAdresse(adresse);
        structurePro.setNom("nom");
        structurePro.setSpecialite("spe");
        mvc.perform(post("/structurePro" )
                .content(asJsonString(structurePro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateStructurePro() throws Exception  {
        StructurePro structurePro = new StructurePro();
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        structurePro.setEnseignantReferent(ensRef);
        structurePro.setMail("mail@mail.com");
        structurePro.setTelephone("06.06.06.06.06");
        Adresse adresse = new Adresse();
        adresse.setCodePostal(59000);
        adresse.setNumero(9);
        adresse.setVille("Lille");
        adresse.setVoie("rue rue");
        structurePro.setAdresse(adresse);
        structurePro.setNom("nom");
        structurePro.setSpecialite("spe");
        structurePro.setStructureProId(1);
        mvc.perform(put("/structurePro" )
                .content(asJsonString(structurePro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
        mvc.perform(get("/structurePro/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteStructurePro() throws Exception  {
        mvc.perform(delete("/structurePro/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/structurePro/2")
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
