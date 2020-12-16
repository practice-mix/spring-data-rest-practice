package com.example.springdatarest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Luo Bao Ding
 * @since 12/14/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class ActorRepositoryTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void deleteByIdNotAllowed() throws Exception {//hide actor DELETE endpoint
        int status = mockMvc.perform(delete("/actors/205")).andReturn().getResponse().getStatus();
        assertEquals(status, 405);
    }

    @Test
    void findByFirstName() throws Exception {
        var result = mockMvc.perform(get("/actors/search/findByFirstName?firstName=PENELOPE")).andReturn().getResponse().getContentAsString();
        System.out.print(result);

    }


//    @Test
//    void findAllByExample() throws Exception {
//        var result = mockMvc.perform(get("/actors/findAll?firstName=PENELOPE")).andReturn().getResponse().getContentAsString();
//        System.out.print(result);
//    }



}