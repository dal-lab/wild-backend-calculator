package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResponseDto;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CalculationListResource extends ResourceMethodHandler {

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String key() {
        return "GET /calculations";
    }

    @Override
    public String handle(String content) throws JsonProcessingException {
        List<Calculation> calculations = calculator.getCalculationList();

        return objectMapper.writeValueAsString(
                CalculationListResponseDto.of(calculations)
        );
    }
}
