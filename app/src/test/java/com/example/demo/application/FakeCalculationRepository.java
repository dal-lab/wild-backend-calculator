package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.CalculationRepository;
import java.util.List;

public class FakeCalculationRepository implements CalculationRepository {

    boolean added = false;

    @Override
    public void add(Calculation calculation) {
        added = true;
    }

    @Override
    public List<Calculation> findAll() {
        return List.of();
    }

    public boolean isAdded() {
        return added;
    }
}
