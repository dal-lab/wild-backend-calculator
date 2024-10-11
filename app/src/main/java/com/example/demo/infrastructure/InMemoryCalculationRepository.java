package com.example.demo.infrastructure;

import com.example.demo.application.CalculationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InMemoryCalculationRepository implements CalculationRepository {
    private final ArrayList<Calculation> calculations = new ArrayList<>();

    @Override
    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    @Override
    public ArrayList<Calculation> getCalculations() {
        return calculations;
    }

    @Override
    public Object getAll() {
        return calculations;
    }
}
