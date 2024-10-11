package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;

import java.util.ArrayList;

public interface CalculationRepository {
    void add(Calculation calculation);

    ArrayList<Calculation> getCalculations();

    Object getAll();
}
