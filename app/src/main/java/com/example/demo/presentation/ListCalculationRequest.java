package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ListCalculationRequest implements RequestMethodHandler {

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handler(String content) throws IOException {
        List<Calculation> calculationList = calculator.getCalculationList();

        return objectMapper.writeValueAsString(
                CalculationListResponseDto.of(calculationList)
        );
    }

    @Override
    public String key() {
        return "GET /calculations";
    }
}
