package com.example.demo.presentation.dto;

import com.example.demo.infrastructure.Calculation;
import java.util.List;
import java.util.stream.Collectors;

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
                        ).collect(Collectors.toList()) // 변경된 부분
        );
    }

    public List<CalculationListItemResponseDto> getCalculations() {
        return calculations;
    }
}
