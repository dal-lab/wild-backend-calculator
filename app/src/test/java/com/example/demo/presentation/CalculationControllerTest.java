package com.example.demo.presentation;

import com.example.demo.application.CalculationRepository;
import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.InMemoryCalculationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculationController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class CalculationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Calculator calculator;

    @Test
    void list() throws Exception {
        List<Calculation> calculations = List.of(
                new Calculation("+", 1, 2, 3)
        );
        when(calculator.getCalculationList()).thenReturn(calculations);

        mockMvc.perform(get("/calculations"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("3")
                ));

        verify(calculator).getCalculationList();
    }

    @Test
    void create() throws Exception {
        when(calculator.calculate(anyInt(), anyInt(), any())).thenReturn(
                new Calculation(("+"), 10, 2, 12)
        );

        String json = """
                {
                    "number1": 10,
                    "number2": 10,
                    "operator": "+"
                }
                """;
        mockMvc.perform(post("/calculations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("12")
                ));
    }
}
