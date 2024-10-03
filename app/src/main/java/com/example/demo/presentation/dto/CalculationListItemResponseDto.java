package com.example.demo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationListItemResponseDto {

    @JsonProperty("number1")
    int number1;
    @JsonProperty("number2")
    int number2;
    @JsonProperty("operation")
    String operation;
    @JsonProperty("result")
    int result;

    public CalculationListItemResponseDto(int number1, int number2,
            String operation, int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }
}
