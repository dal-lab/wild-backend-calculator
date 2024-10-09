package com.example.demo;

import com.example.demo.application.Calculator;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.FakeCalculationRepository;
import com.example.demo.infrastructure.InMemoryCalculationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {
    FakeCalculationRepository calculationRepository;
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculationRepository = new FakeCalculationRepository();
        calculator = new Calculator(calculationRepository);
    }
    @Test
    void plus() {
        Calculation calculation = calculator.calculate(2,1,"+");
        assertThat(calculation.getResult()).isEqualTo(3);
    }
    @Test
    void minus() {
        Calculation calculation = calculator.calculate(2,1,"-");
        assertThat(calculation.getResult()).isEqualTo(1);
    }
    @Test
    void divide() {
        Calculation calculation = calculator.calculate(2,1,"*");
        assertThat(calculation.getResult()).isEqualTo(2);
    }
    @Test
    void multiply() {
        Calculation calculation = calculator.calculate(2,1,"/");
        assertThat(calculation.getResult()).isEqualTo(2);
    }
}
