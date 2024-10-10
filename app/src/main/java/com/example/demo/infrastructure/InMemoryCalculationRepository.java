package com.example.demo.infrastructure;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCalculationRepository {

    private final List<Calculation> calculations = new ArrayList<>();

    public void add(Calculation calculation) {
        calculations.add(calculation);
    }

    public List<Calculation> findAll() {
        return new ArrayList<>(calculations);
    }
}
