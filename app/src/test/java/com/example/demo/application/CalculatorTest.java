package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class CalculatorTest {
    private Calculator calculator;
    private CalculationRepository calculationRepository;

    @BeforeEach
    void setUp() {
        calculationRepository = mock(CalculationRepository.class);
        calculator = new Calculator(calculationRepository);
    }

    @Test
    void plus() {
        Calculation calculation = calculator.calculate(2, 1, "+");
        assertThat(calculation.getResult()).isEqualTo(3);
        verify(calculationRepository).add(any(Calculation.class));
    }

    @Test
    void minus() {
        Calculation calculation = calculator.calculate(2, 1, "-");
        assertThat(calculation.getResult()).isEqualTo(1);
        verify(calculationRepository).add(any(Calculation.class));
    }

    @Test
    void divide() {
        Calculation calculation = calculator.calculate(2, 1, "*");
        assertThat(calculation.getResult()).isEqualTo(2);
        verify(calculationRepository).add(any(Calculation.class));
    }

    @Test
    void multiply() {
        Calculation calculation = calculator.calculate(2, 1, "/");
        assertThat(calculation.getResult()).isEqualTo(2);
        verify(calculationRepository).add(any(Calculation.class));
    }
    
    @Test
    void divideZero() {
        assertThatThrownBy(() -> {
            calculator.calculate(10, 0, "/");
        });
        verify(calculationRepository, never()).add(any());
    }
}
