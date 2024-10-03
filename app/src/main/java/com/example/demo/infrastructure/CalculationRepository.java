package com.example.demo.infrastructure;

import java.util.ArrayList;

public class CalculationRepository {
    private final ArrayList<Calculation> calculations = new ArrayList<>();
    private static CalculationRepository instance = null;

    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    public ArrayList<Calculation> getCalculations() {
        return calculations;
    }

    public static CalculationRepository getInstance() {
        if (instance == null) {
            instance = new CalculationRepository();
        }
        return instance;
    }
}
