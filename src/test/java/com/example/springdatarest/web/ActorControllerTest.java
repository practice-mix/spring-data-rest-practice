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
 * @since 12/13/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class ActorControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getOne() throws Exception {
        String result = mockMvc.perform(get("/actors/search/getOne")).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


}