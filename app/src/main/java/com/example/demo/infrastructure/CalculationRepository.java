package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class CalculationRepository {

    private final List<Calculation> calculations = new ArrayList<>();

    public CalculationRepository() {
    }

    public void add(Calculation calculation) {
        calculations.add(calculation);
    }
}
