package com.example.demo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CalculationListItemResponseDto(
        @JsonProperty("number1") int number1,
        @JsonProperty("number2") int number2,
        @JsonProperty("operation") String operation,
        @JsonProperty("result") int result
) {

}
