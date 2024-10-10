package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.InMemoryCalculationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private InMemoryCalculationRepository calculationRepository;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculationRepository = new InMemoryCalculationRepository();
        calculator = new Calculator(calculationRepository);
    }

    @Test
    void plus() {
        Calculation calculate = calculator.calculate(1, 2, "+");

        assertThat(calculate.getResult()).isEqualTo(3);
    }

    @Test
    void minus() {
        Calculation calculate = calculator.calculate(3, 1, "-");

        assertThat(calculate.getResult()).isEqualTo(2);
    }

    @Test
    void divide() {
        Calculation calculate = calculator.calculate(4, 2, "/");

        assertThat(calculate.getResult()).isEqualTo(2);
    }

    @Test
    void multiply() {
        Calculation calculate = calculator.calculate(3, 1, "*");

        assertThat(calculate.getResult()).isEqualTo(3);
    }
}
