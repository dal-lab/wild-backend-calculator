package com.example.demo.presentation.dto;

import java.util.List;

public class CalculationListResponseDto {
    private final List<CalculationResponseDto> calculations;

    public CalculationListResponseDto(List<CalculationResponseDto> calculations) {
        this.calculations = calculations;
    }

    public List<CalculationResponseDto> getCalculations() {
        return calculations;
    }
}
