package com.example.t1test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * The type Controller test.
 *
 * @author Glushko Nikita
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test for successful request.
     *
     * @throws Exception the exception
     */
    @Test
    public void getSymbolFrequencySuccess() throws Exception {
        mockMvc.perform(get("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("string", "aaabbbcc"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.size()").value(3));
    }

    /**
     * Test for bad request.
     *
     * @throws Exception the exception
     */
    @Test
    public void getSymbolFrequencyBadRequest() throws Exception {
        mockMvc.perform(get("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Test for user's wrong input.
     *
     * @throws Exception the exception
     */
    @Test
    public void getSymbolFrequencyFail() throws Exception {
        mockMvc.perform(get("/api/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("string", ""))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$").value("Неверный формат ввода"));
    }
}