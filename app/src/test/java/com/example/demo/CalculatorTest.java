package com.example.demo;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.FakeCalculationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    FakeCalculationRepository calculationRepository;
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculationRepository = new FakeCalculationRepository();
        calculator = new Calculator(calculationRepository);
    }

    @Test
    void plus() {
        Calculation calculation = calculator.calculate(1, 1, "+");
        assertThat(calculation.getResult()).isEqualTo(2);
    }

    @Test
    void minus() {
        Calculation calculation = calculator.calculate(1, 1, "-");
        assertThat(calculation.getResult()).isEqualTo(0);
    }

    @Test
    void multiply() {
        Calculation calculation = calculator.calculate(1, 1, "*");
        assertThat(calculation.getResult()).isEqualTo(1);
    }

    @Test
    void divide() {
        Calculation calculation = calculator.calculate(10, 2, "/");
        assertThat(calculation.getResult()).isEqualTo(5);
    }
}
