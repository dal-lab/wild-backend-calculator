package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorPlusTest {

    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new OperatorPlus();
    }

    @Test
    void plus() {
        int calculate = operator.calculate(1, 2);

        assertThat(calculate).isEqualTo(3);
    }
}
