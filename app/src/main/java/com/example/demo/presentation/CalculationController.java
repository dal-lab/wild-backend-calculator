package com.example.demo.presentation;


import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResponseDto;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculations")
public class CalculationController {
    private final Calculator calculator;
    private final ObjectMapper objectMapper;

    CalculationController(Calculator calculator, ObjectMapper objectMapper) {
        this.calculator = calculator;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public CalculationListResponseDto list() {
        List<Calculation> calculations = calculator.getCalculations();
        return CalculationListResponseDto.of(calculations);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CalculationResponseDto create(
            @RequestBody
            CalculationRequestDto requestDto
    ) {
        Calculation result = calculator.calculate(requestDto.number1(), requestDto.number2(), requestDto.operator());
        return
                new CalculationResponseDto(
                        requestDto.number1(),
                        requestDto.number2(),
                        requestDto.operator(),
                        result.getResult()
                );
    }

    public String getKey() {
        return "POST /calculations";
    }
}
