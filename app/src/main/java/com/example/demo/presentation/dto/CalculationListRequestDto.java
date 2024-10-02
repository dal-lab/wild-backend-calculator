package com.example.demo.presentation.dto;

import com.example.demo.infrastructure.Calculation;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationListRequestDto {

    List<CalculationResponseDto> calculations;

    public CalculationListRequestDto(
            List<CalculationResponseDto> calculations) {
        this.calculations = calculations;
    }

    public static CalculationListRequestDto of(List<Calculation> calculations) {
        return new CalculationListRequestDto(
                calculations.stream()
                        .map(calculation -> {
                                    return new CalculationResponseDto(
                                            calculation.getNumber1(),
                                            calculation.getNumber2(),
                                            calculation.getOperation(),
                                            calculation.getResult()
                                    );
                                }
                        ).collect(Collectors.toList())
        );
    }
}
