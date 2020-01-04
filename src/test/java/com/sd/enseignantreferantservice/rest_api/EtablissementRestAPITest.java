package com.sd.enseignantreferantservice.rest_api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class EtablissementRestAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getEtablissement() {
    }

    @Test
    public void getListEtablissement() {
    }

    @Test
    public void addEtablissement() {
    }

    @Test
    public void updateEtablissement() {
    }

    @Test
    public void deleteEtablissement() {
    }
}
