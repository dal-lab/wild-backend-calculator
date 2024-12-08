package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.dto.CalculationRequestDto;
import com.example.demo.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CalculationCreateResource extends ResourceMethodHandler {

    public final static String KEY = "POST /calculations";

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();


    public String handle(String content) throws JsonProcessingException {

        CalculationRequestDto requestDto =
                objectMapper.readValue(content, CalculationRequestDto.class);

        int result = calculator.calculate(
                requestDto.getNumber1(),
                requestDto.getNumber2(),
                requestDto.getOperator());

        return objectMapper.writeValueAsString(
                new CalculationResponseDto(
                        requestDto.getNumber1(),
                        requestDto.getNumber2(),
                        requestDto.getOperator(),
                        result
                ));

    }
}
