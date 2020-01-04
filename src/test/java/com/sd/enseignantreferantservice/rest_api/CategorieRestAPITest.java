package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.Categorie;
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

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class CategorieRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCategorie()  throws Exception{
        mvc.perform(get("/categorie/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Administratif"));
    }

    @Test
    public void getListCategorie()  throws Exception{
        mvc.perform(get("/categories/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    @Rollback
    @Transactional
    public void addCategorie()  throws Exception{
        Categorie categorie = new Categorie();
        categorie.setNom("nom");
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        categorie.setEnseignantReferent(ensRef);
        mvc.perform(post("/categorie" )
                .content(asJsonString(categorie))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateCategorie()  throws Exception{
        Categorie categorie = new Categorie();
        categorie.setNom("nom");
        EnseignantReferent ensRef= new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        categorie.setEnseignantReferent(ensRef);
        categorie.setCategorieId(2);
        mvc.perform(put("/categorie" )
                .content(asJsonString(categorie))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
        mvc.perform(get("/categorie/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteCategorie() throws Exception {
        mvc.perform(delete("/categorie/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/categorie/2")
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
