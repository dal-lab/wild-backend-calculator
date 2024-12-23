package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationListResposeDto;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculations")
public class CalculationController {
    private final Calculator calculator;

    public CalculationController(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping
    public CalculationListResposeDto list() {

        List<Calculation> calculations = calculator.getCalculationList();

        return CalculationListResposeDto.of(calculations);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CalculationResponseDto create(
            @RequestBody CalculationRequestDto requestDto) {
        Calculation calculation = calculator.calculate(requestDto.getNumber1(), requestDto.getNumber2(), requestDto.getOperator());

        return new CalculationResponseDto(
                calculation.getNumber1(),
                calculation.getNumber2(),
                calculation.getOperator(),
                calculation.getResult()
        );
    }
}
