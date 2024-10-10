package com.example.demo.presentation;

import com.example.demo.application.CalculationRepository;
import com.example.demo.application.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculationController.class)
class CalculationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private Calculator calculator;

    @MockBean
    private CalculationRepository calculationRepository;

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/calculations"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        assertThat(calculationRepository.getAll()).hasSize(0);
        String json = """
                {
                    "number1": 10,
                    "number2": 2,
                    "operator": "+"
                }
                """;
        mockMvc.perform(post("/calculations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("12")));

        verify(calculationRepository).add(any());
    }
}
