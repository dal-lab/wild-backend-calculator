package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.dto.CalculationListResponseDto;
import com.example.demo.dto.CalculationRequestDto;
import com.example.demo.dto.CalculationResponseDto;
import com.example.demo.infrastructure.Calculation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CalculationListHandler extends ResourceMethodHandler {

    public final static String KEY = "GET /calculations";

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handle(String content) throws JsonProcessingException {

        List<Calculation> calculations = calculator.getCalculations();

        System.out.println(calculations);

        return objectMapper.writeValueAsString(
                new CalculationListResponseDto(
                        calculations.stream()
                                .map(calculation -> new CalculationResponseDto(
                                        calculation.getNumber1(),
                                        calculation.getNumber2(),
                                        calculation.getOperator(),
                                        calculation.getResult()
                                ))
                                .toList()
                ));

    }
}
