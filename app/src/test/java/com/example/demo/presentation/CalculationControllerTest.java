package com.example.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    void list() throws Exception {
        mockMvc.perform(get("/calculations"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    void create() throws Exception {
        String json = "{\"left\": 1, \"right\": 2, \"operator\": \"+\"}";
        String result = "{\"left\":1,\"right\":2,\"operator\":\"+\",\"result\":3}";
        mockMvc.perform(post("/calculations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("3")));
    }


}
