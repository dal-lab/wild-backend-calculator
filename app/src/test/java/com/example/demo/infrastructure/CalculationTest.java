package com.example.demo.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculationTest {

    private Calculation calculation;

    @BeforeEach
    void setUp() {
        calculation = new Calculation(1, 2, "+", 3);
    }

    @Test
    void getCalculation() {
        assertThat(calculation.getNumber1()).isEqualTo(1);
        assertThat(calculation.getNumber2()).isEqualTo(2);
        assertThat(calculation.getOperation()).isEqualTo("+");
        assertThat(calculation.getResult()).isEqualTo(3);
    }
}
