package com.example.springdatarest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class MyFlightRepositoryTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void findOne() throws Exception {
        String result = mockMvc.perform(get("/myFlights/1")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    void myFlightSummary() throws Exception {
        String result = mockMvc.perform(get("/myFlights/1?projection=MyFlightSummary")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}