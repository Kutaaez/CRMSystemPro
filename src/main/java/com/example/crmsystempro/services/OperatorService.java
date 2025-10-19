package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {
    @Autowired
    private OperatorRepository operatorRepository;

    public List<Operators> getAllOperators() {
        return operatorRepository.findAll();
    }
    public void addOperator(Operators operator) {
        operatorRepository.save(operator);

    }
}