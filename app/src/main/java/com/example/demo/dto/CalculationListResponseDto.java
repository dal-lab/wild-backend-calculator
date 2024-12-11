package com.example.demo.dto;


import java.util.ArrayList;
import java.util.List;

public class CalculationListResponseDto {
    private final List<CalculationResponseDto> calculations;

    public CalculationListResponseDto(List<CalculationResponseDto> calculations) {
        this.calculations = calculations;
    }

    public List<CalculationResponseDto> getCalculations() {
        return new ArrayList<>(calculations);
    }
}
