package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCalculationRepository implements CalculationRepository {

    private final List<Calculation> calculations = new ArrayList<>();

    @Override
    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    @Override
    public List<Calculation> findAll() {
        return new ArrayList<>(calculations);
    }
}
