package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResponseDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CalculationListResource extends ResourceMethodHandler {
    private final Calculator calculator = new Calculator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handle(String content) throws JsonProcessingException {
        List<Calculation> calculations = calculator.getCalculations();
        return objectMapper.writeValueAsString(
                new CalculationListResponseDto(calculations.stream().map(
                        calculation -> new CalculationResponseDto(
                                calculation.getNumber1(),
                                calculation.getNumber2(),
                                calculation.getOperator(),
                                calculation.getResult()
                        )
                ).collect(Collectors.toList()))
        );
    }

    public String getKey() {
        return "GET /calculations";
    }

}
