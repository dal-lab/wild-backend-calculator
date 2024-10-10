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
    void calculateAddition() {
        Calculation calculation = calculator.calculate(1, 2, "+");
        assertThat(calculation.getResult()).isEqualTo(3);
    }

    @Test
    void calculateSubtraction() {
        Calculation calculation = calculator.calculate(5, 3, "-");
        assertThat(calculation.getResult()).isEqualTo(2);
    }

    @Test
    void calculateMultiplication() {
        Calculation calculation = calculator.calculate(4, 3, "*");
        assertThat(calculation.getResult()).isEqualTo(12);
    }

    @Test
    void calculateDivision() {
        Calculation calculation = calculator.calculate(8, 2, "/");
        assertThat(calculation.getResult()).isEqualTo(4);
    }
}
