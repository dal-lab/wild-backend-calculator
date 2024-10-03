package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class ListCalculationRequest implements RequestMethodHandler {

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handler(String content) throws IOException {
        List<Calculation> calculationList = calculator.getCalculationList();

        String jsonResponse = objectMapper.writeValueAsString(
                CalculationListResponseDto.of(calculationList)
        );

        return jsonResponse;
    }
}
