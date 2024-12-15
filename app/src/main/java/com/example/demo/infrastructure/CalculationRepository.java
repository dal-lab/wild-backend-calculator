package com.example.demo.infrastructure;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculationRepository {
    private final List<Calculation> calculations = new ArrayList<>();

    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    public List<Calculation> getAll() {
        return new ArrayList<>(calculations);
    }
}
