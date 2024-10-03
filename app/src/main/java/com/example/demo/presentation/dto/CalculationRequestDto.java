package com.example.demo.presentation.dto;

import java.util.Arrays;
import java.util.Set;

/**
 * 계산 요청을 위한 DTO
 *
 * @param number1  첫 번째 피연산자
 * @param number2  두 번째 피연산자
 * @param operator 연산자 ("+", "-", "*", "/" 중 하나)
 */
public record CalculationRequestDto(
        int number1,
        int number2,
        String operator
) {
    private static final Set<String> VALID_OPERATORS = Set.of("+", "-", "*", "/");

    public CalculationRequestDto {
        if (!VALID_OPERATORS.contains(operator)) {
            throw new IllegalArgumentException("Invalid operator. Must be one of +, -, *, /");
        }
    }
}
