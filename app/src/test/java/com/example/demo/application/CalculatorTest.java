package com.example.demo.application;
import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.FakeCalculationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp(){
        FakeCalculationRepository calculationRepository = new FakeCalculationRepository();
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
