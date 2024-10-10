package com.example.demo.presentation.dto;

import com.example.demo.infrastructure.Calculation;
import java.util.List;
import java.util.stream.Collectors;

public record CalculationListResponseDto(
        List<CalculationListItemResponseDto> calculations
) {

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
                        ).collect(Collectors.toList())
        );
    }
}
