package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class CalculationPostHandler implements RequestMethodHandler {

    private final Calculator calculator;
    private final ObjectMapper objectMapper;

    public CalculationPostHandler(Calculator calculator,
            ObjectMapper objectMapper) {
        this.calculator = calculator;
        this.objectMapper = objectMapper;
    }

    @Override
    public String handler(String content) throws IOException {
        CalculationRequestDto calculationRequestDto = objectMapper.readValue(
                content,
                CalculationRequestDto.class
        );

        Calculation calculate = calculator.calculate(
                calculationRequestDto.getNumber1(),
                calculationRequestDto.getNumber2(),
                calculationRequestDto.getOperator());

        return objectMapper.writeValueAsString(
                new CalculationResponseDto(
                        calculate.getResult()
                )
        );
    }

    @Override
    public String key() {
        return "POST /calculations";
    }
}
