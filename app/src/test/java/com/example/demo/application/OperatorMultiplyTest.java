package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorMultiplyTest {

    private Operator operator;

    @BeforeEach
    void setUp() {
        operator = new OperatorMultiply();
    }

    @Test
    void multiply() {
        int calculate = operator.calculate(4, 2);

        assertThat(calculate).isEqualTo(8);
    }
}
