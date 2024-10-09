package com.example.demo.presentation;


import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CalculationCreateHandler extends ResourceMethodHandler {
    private final Calculator calculator;
    private final ObjectMapper objectMapper;

    CalculationCreateHandler(Calculator calculator, ObjectMapper objectMapper) {
        this.calculator = calculator;
        this.objectMapper = objectMapper;

    }

    public String handle(String content) throws JsonProcessingException {
        try {
            CalculationRequestDto requestDto = objectMapper.readValue(content, CalculationRequestDto.class);
            Calculation result = calculator.calculate(requestDto.number1(), requestDto.number2(), requestDto.operator());
            return objectMapper.writeValueAsString(
                    new CalculationResponseDto<>(
                            requestDto.number1(),
                            requestDto.number2(),
                            requestDto.operator(),
                            result.getResult()
                    )
            );
        } catch (IllegalArgumentException e) {
            return "잘못된 입력입니다: " + e.getMessage();
        } catch (ArithmeticException e) {
            return "계산 오류: " + e.getMessage();
        }
    }

    public String getKey() {
        return "POST /calculations";
    }
}
