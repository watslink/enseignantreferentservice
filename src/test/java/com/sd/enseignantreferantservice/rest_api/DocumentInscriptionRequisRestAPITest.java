package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
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
public class DocumentInscriptionRequisRestAPITest {

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
    public void getDocumentInscriptionRequis() throws Exception {
        mvc.perform(get("/documentInscriptionRequis/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Dossier d'inscription"));
    }

    @Test
    public void getListDocumentInscriptionRequis() throws Exception {
        mvc.perform(get("/documentInscriptionRequiss/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @Rollback
    @Transactional
    public void addDocumentInscriptionRequis() throws Exception {
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        DocumentInscriptionRequis documentInscriptionRequis = new DocumentInscriptionRequis();
        documentInscriptionRequis.setEnseignantReferent(ensRef);
        documentInscriptionRequis.setNom("document");
        mvc.perform(post("/documentInscriptionRequis")
                .content(asJsonString(documentInscriptionRequis))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("document"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateDocumentInscriptionRequis() throws Exception {
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        DocumentInscriptionRequis documentInscriptionRequis = new DocumentInscriptionRequis();
        documentInscriptionRequis.setEnseignantReferent(ensRef);
        documentInscriptionRequis.setNom("document");
        documentInscriptionRequis.setDocumentInscriptionRequisId(1);
        mvc.perform(put("/documentInscriptionRequis")
                .content(asJsonString(documentInscriptionRequis))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("document"));
        mvc.perform(get("/documentInscriptionRequis/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("document"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteDocumentInscriptionRequis() throws Exception {
        mvc.perform(delete("/documentInscriptionRequis/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/documentInscriptionRequis/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());

    }
}
