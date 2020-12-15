package com.example.springdatarest.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Luo Bao Ding
 * @since 12/15/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class MyAirportRepositoryRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void takeByNameRepositoryRest() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/takeByNameRepositoryRestExample?name=name2")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    void findByName() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/findByName?name=name2")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    void takeByName() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/takeByName?name=name2")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}