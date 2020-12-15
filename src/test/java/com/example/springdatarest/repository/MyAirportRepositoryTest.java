package com.example.springdatarest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class MyAirportRepositoryTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    void findBySizeGreaterThanEqual() throws Exception {
        String result = mockMvc.perform(get("/myAirports/search/findBySizeGreaterThanEqual?size=3")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    void findById() throws Exception {
        String result = mockMvc.perform(get("/myAirports/1")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

}