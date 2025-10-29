package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.Operators;
import java.util.List;

public interface OperatorService {
    List<Operators> getAllOperators();
    void addOperator(Operators operator);
}
