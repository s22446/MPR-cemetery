package com.pjatk.cemetery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CemeteryRestControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_createExampleCemetery() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/cemetery/createExampleCemetery");

        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":2,\"name\":\"PrzykÅ\u0082adowy cmentarz\",\"corpseList\":[{\"id\":2,\"name\":\"Jan\",\"surname\":\"Nowak\",\"ageWhenDied\":50,\"sex\":\"MALE\"}],\"opened\":true}"));
    }

    @Test
    void shouldReturnSuccess_createCemetery() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/cemetery/createCemetery").param("name", "Cmentarz test");

        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Cmentarz test\",\"corpseList\":[{\"id\":1,\"name\":\"Janina\",\"surname\":\"Nowak\",\"ageWhenDied\":75,\"sex\":\"FEMALE\"}],\"opened\":true}"));
    }

    @Test
    void shouldReturnSuccess_getCemeteryList() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/cemetery/getCemeteryList");

        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"Cmentarz test\",\"corpseList\":[{\"id\":1,\"name\":\"Janina\",\"surname\":\"Nowak\",\"ageWhenDied\":75,\"sex\":\"FEMALE\"}],\"opened\":true}]"));
    }

    @Test
    void shouldReturnSuccess_getCemeteryById() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/cemetery/getCemeteryById").param("id", "1");

        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Cmentarz test\",\"corpseList\":[{\"id\":1,\"name\":\"Janina\",\"surname\":\"Nowak\",\"ageWhenDied\":75,\"sex\":\"FEMALE\"}],\"opened\":true}"));
    }

    @Test
    void shouldReturnSuccess_getAllWithIdGreaterThan() throws Exception {
        MockHttpServletRequestBuilder getRequestBuilder = get("/cemetery/getAllWithIdGreaterThan").param("id", "0");

        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
