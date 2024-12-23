package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.verification.VerificationMode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.awaitility.Awaitility.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CalculatorTest {
    private CalculationRepository calculationRepository;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculationRepository = mock(CalculationRepository.class);  //interface를 분석해서 mock 객체를 만들어준다?

        calculator = new Calculator(calculationRepository);
    }

    @Test
    void plus() {
        Calculation calculation = calculator.calculate(1, 1, "+");
        assertThat(calculation.getResult()).isEqualTo(2);

        verify(calculationRepository, never()).add(any(Calculation.class));
//        assertThat(calculationRepository.isAdded()).isTrue();
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

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> {
            calculator.calculate(10, 0, "/");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        });

//        assertThat(calculationRepository.isAdded()).isFalse();
    }

    @Test
    void getCalculationList() {
        List<Calculation> calculations = List.of(
                new Calculation("+", 1, 2, 3)
        );
        when(calculationRepository.getAll()).thenReturn(calculations);

        assertThat(calculator.getCalculationList()).hasSize(1);
    }
}
