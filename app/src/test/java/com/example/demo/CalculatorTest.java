package com.example.demo;

import com.example.demo.application.CalculationRepository;
import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CalculatorTest {
    private CalculationRepository calculationRepository;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculationRepository = mock(CalculationRepository.class);

        when(calculationRepository.getAll()).thenReturn(List.of(
                new Calculation(1, 2, "+", 3)
        ));
        calculator = new Calculator(calculationRepository);
    }

    @Test
    void calculateAddition() {
        Calculation calculation = calculator.calculate(1, 2, "+");
        assertThat(calculation.getResult()).isEqualTo(3);
        verify(calculationRepository).add(any());
    }

    @Test
    void calculateSubtraction() {
        Calculation calculation = calculator.calculate(5, 3, "-");
        assertThat(calculation.getResult()).isEqualTo(2);
        verify(calculationRepository).add(any());
    }

    @Test
    void calculateMultiplication() {
        Calculation calculation = calculator.calculate(4, 3, "*");
        assertThat(calculation.getResult()).isEqualTo(12);
        verify(calculationRepository).add(any());
    }

    @Test
    void calculateDivision() {
        Calculation calculation = calculator.calculate(8, 2, "/");
        assertThat(calculation.getResult()).isEqualTo(4);
        verify(calculationRepository).add(any());
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> {
            calculator.calculate(8, 0, "/");
        });
        verify(calculationRepository, never()).add(any());
    }

    @Test
    void getCalulationList() {
        List<Calculation> calculations = List.of(
                new Calculation(1, 2, "+", 3)
        );
        when(calculationRepository.getAll()).thenReturn(calculations);
        assertThat(calculations).hasSize(1);
    }
}
