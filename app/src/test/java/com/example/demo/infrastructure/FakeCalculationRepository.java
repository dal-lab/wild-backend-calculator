package com.example.demo.infrastructure;

import com.example.demo.application.CalculationRepository;

import java.util.List;

public class FakeCalculationRepository implements CalculationRepository {
    @Override
    public void add(Calculation calculation) {

    }

    @Override
    public List<Calculation> getAll() {
        return List.of();
    }
}
