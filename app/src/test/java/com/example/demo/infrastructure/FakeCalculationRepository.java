package com.example.demo.infrastructure;

import com.example.demo.application.CalculationRepository;

import java.util.ArrayList;

public class FakeCalculationRepository implements CalculationRepository {
    private final ArrayList<Calculation> calculations = new ArrayList<>();

    @Override
    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    @Override
    public ArrayList<Calculation> getCalculations() {
        return calculations;
    }
}

