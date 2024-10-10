package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorDivideTest {

    private Operator operatorDivide;

    @BeforeEach
    void setUp() {
        operatorDivide = new OperatorDivide();
    }

    @Test
    void divide() {
        int calculate = operatorDivide.calculate(4, 2);

        assertThat(calculate).isEqualTo(2);
    }
}
