package com.example.demo.infrastructure;

import java.util.List;

public interface CalculationRepository {

    void add(Calculation calculation);

    List<Calculation> findAll();
}
