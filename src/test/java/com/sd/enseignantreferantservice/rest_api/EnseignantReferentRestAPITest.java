package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class EnseignantReferentRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EnseignantReferentRestAPI enseignantReferentRestAPI;

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
    public void getEnseignantReferent() throws Exception {
        mvc.perform(get("/enseignantReferent/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Jean"));
    }

    @Test
    public void getEnseignantReferentByMail() throws Exception {
        mvc.perform(get("/enseignantReferentByMail/jean.dupont@mail.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Jean"));
    }

    @Test
    public void getListEnseignantReferent() throws Exception {
        mvc.perform(get("/enseignantReferents")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @Rollback
    @Transactional
    public void addEnseignantReferent() throws Exception {
        EnseignantReferent enseignantReferent = new EnseignantReferent();
        enseignantReferent.setNom("nom");
        enseignantReferent.setPrenom("prenom");
        enseignantReferent.setMotDePasse("pass");
        enseignantReferent.setMail("mail@mail.com");
        enseignantReferent.setEnabled(true);
        enseignantReferentRestAPI.addEnseignantReferent(enseignantReferent);
        mvc.perform(get("/enseignantReferentByMail/mail@mail.com")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateMailEnseignantReferent() throws Exception {

        mvc.perform(put("/enseignantReferentMail")
                .param("id", "1")
                .param("newMail", "mail@mail.com")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mail").value("mail@mail.com"));
        mvc.perform(get("/enseignantReferent/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mail").value("mail@mail.com"));
    }

    @Test
    @Rollback
    @Transactional
    public void updatePasswordEnseignantReferent() throws Exception {
        mvc.perform(put("/enseignantReferentPassword")
                .param("id", "1")
                .param("oldPass", "motdepasse")
                .param("newPass", "newmotdepasse")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

    @Test
    @Rollback
    @Transactional
    public void updatePasswordEnseignantReferentWithWrongOldPass() throws Exception {
        mvc.perform(put("/enseignantReferentPassword")
                .param("id", "1")
                .param("oldPass", "passe")
                .param("newPass", "newmotdepasse")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(false));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteEnseignantReferent() throws Exception {
        mvc.perform(delete("/enseignantReferent/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/enseignantReferent/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @Rollback
    @Transactional
    public void reinitializeAllRDV() throws Exception {
        mvc.perform(get("/enseignantReferentReinitRDV/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
