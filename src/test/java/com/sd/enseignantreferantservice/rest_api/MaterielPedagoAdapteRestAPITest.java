package com.sd.enseignantreferantservice.rest_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sd.enseignantreferantservice.model.EnseignantReferent;
import com.sd.enseignantreferantservice.model.MaterielPedagoAdapte;
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
public class MaterielPedagoAdapteRestAPITest {

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
    public void getMaterielPedagoAdapte() throws Exception {
        mvc.perform(get("/materielPedagoAdapte/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("ordinateur"));
    }

    @Test
    public void getListMaterielPedagoAdapte() throws Exception {
        mvc.perform(get("/materielPedagoAdaptes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    @Rollback
    @Transactional
    public void addMaterielPedagoAdapte() throws Exception {
        MaterielPedagoAdapte materielPedagoAdapte = new MaterielPedagoAdapte();
        materielPedagoAdapte.setNom("nom");
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        materielPedagoAdapte.setEnseignantReferent(ensRef);
        mvc.perform(post("/materielPedagoAdapte")
                .content(asJsonString(materielPedagoAdapte))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void updateMaterielPedagoAdapte() throws Exception {
        MaterielPedagoAdapte materielPedagoAdapte = new MaterielPedagoAdapte();
        materielPedagoAdapte.setNom("nom");
        EnseignantReferent ensRef = new EnseignantReferent();
        ensRef.setEnseignantReferentId(1);
        materielPedagoAdapte.setEnseignantReferent(ensRef);
        materielPedagoAdapte.setMaterielPedagoAdapteId(1);
        mvc.perform(put("/materielPedagoAdapte")
                .content(asJsonString(materielPedagoAdapte))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
        mvc.perform(get("/materielPedagoAdapte/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("nom"));
    }

    @Test
    @Rollback
    @Transactional
    public void deleteMaterielPedagoAdapte() throws Exception {
        mvc.perform(delete("/materielPedagoAdapte/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(get("/materielPedagoAdapte/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
