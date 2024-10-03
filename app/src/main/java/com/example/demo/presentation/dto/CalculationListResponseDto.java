package com.example.demo.presentation.dto;

import static java.util.stream.Collectors.toList;

import com.example.demo.infrastructure.Calculation;
import java.util.List;

public class CalculationListResponseDto {

    List<CalculationListItemResponseDto> calculations;

    public CalculationListResponseDto(
            List<CalculationListItemResponseDto> calculations) {
        this.calculations = calculations;
    }

    public static CalculationListResponseDto of(
            List<Calculation> calculations) {
        return new CalculationListResponseDto(
                calculations.stream()
                        .map(calculation -> new CalculationListItemResponseDto(
                                        calculation.getNumber1(),
                                        calculation.getNumber2(),
                                        calculation.getOperation(),
                                        calculation.getResult()
                                )
                        ).collect(toList())
        );
    }
}
