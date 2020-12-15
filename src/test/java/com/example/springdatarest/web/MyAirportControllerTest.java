package com.example.springdatarest.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class MyAirportControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void takeByNameRest() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/takeByNameRest?name=name2")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }



    @Test
    void takeById() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/takeById?id=1")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    void obtainByName() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/obtainByName?name=name2")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}