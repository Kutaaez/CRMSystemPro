package com.example.crmsystempro.services.impl;

import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.repository.OperatorRepository;
import com.example.crmsystempro.services.OperatorService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public List<Operators> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public void addOperator(Operators operator) {
        operatorRepository.save(operator);
    }
}
