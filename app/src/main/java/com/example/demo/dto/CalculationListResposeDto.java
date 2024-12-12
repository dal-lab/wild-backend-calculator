package com.example.demo.dto;

import com.example.demo.infrastructure.Calculation;

import java.util.List;
import java.util.stream.Collectors;

public class CalculationListResposeDto {
    private final List<CalculationResposeDto> calculations;

    public CalculationListResposeDto(List<CalculationResposeDto> calculations) {
        this.calculations = calculations;
    }

    public static CalculationListResposeDto of(List<Calculation> calculations) {
        return new CalculationListResposeDto(
                calculations.stream()
                        .map(calculation ->
                                new CalculationResposeDto(
                                        calculation.getNumber1(),
                                        calculation.getNumber2(),
                                        calculation.getOperator(),
                                        calculation.getResult()
                                )
                        ).collect(Collectors.toList())
        );
    }

    public List<CalculationResposeDto> getCalculations() {
        return calculations;
    }
}

