package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.AESH;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class AESHRestAPITest {

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
    public void getAESH() throws Exception {
        mvc.perform(get("/aesh/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Tessier"));
    }

    @Test
    public void getListAESH() throws Exception {
        mvc.perform(get("/aeshs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)));
    }

    @Test
    @Rollback
    @Transactional
    public void addAESH() throws Exception {
        AESH aesh = new AESH();
        PIAL pial = new PIAL();
        pial.setPialId(1);
        aesh.setPial(pial);
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        aesh.setEnseignantReferent(ensRef);
        aesh.setMail("mail@mail.com");
        aesh.setTelephone("06.06.06.06.06");
        aesh.setNom("nom");
        aesh.setPrenom("prenom");
        mvc.perform(post("/aesh")
                .content(asJsonString(aesh))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateAESH() throws Exception {
        AESH aesh = new AESH();
        PIAL pial = new PIAL();
        pial.setPialId(1);
        aesh.setPial(pial);
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        aesh.setAeshId(2);
        aesh.setEnseignantReferent(ensRef);
        aesh.setMail("mail@mail.com");
        aesh.setTelephone("06.06.06.06.06");
        aesh.setNom("nom");
        aesh.setPrenom("prenom");
        mvc.perform(put("/aesh")
                .content(asJsonString(aesh))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
        mvc.perform(get("/aesh/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteAESH() throws Exception {
        mvc.perform(delete("/aesh/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/aesh/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
