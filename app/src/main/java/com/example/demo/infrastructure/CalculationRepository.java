package com.example.demo.infrastructure;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CalculationRepository {
    private final ArrayList<Calculation> calculations = new ArrayList<>();

    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    public ArrayList<Calculation> getCalculations() {
        return calculations;
    }

}
