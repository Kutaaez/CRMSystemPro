package com.example.crmsystempro.services.impl;

import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.repository.OperatorRepository;
import com.example.crmsystempro.services.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorServiceImpl implements OperatorService {

    private final OperatorRepository operatorRepository;
    @Override
    public Operators addOperator(Operators operator) {
        return operatorRepository.save(operator);    }

    @Override
    public List<Operators> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Operators getOperatorById(Long id) {
        return operatorRepository.findById(id).orElse(null);
    }

    @Override
    public Operators updateOperator(Long id, Operators operator) {
        Operators existingOperator = operatorRepository.findById(id).orElse(null);
        if (existingOperator != null) {
            existingOperator.setName(operator.getName());
            existingOperator.setSurname(operator.getSurname());
            existingOperator.setDepartment(operator.getDepartment());
            return operatorRepository.save(existingOperator);
        }
        return null;
    }

    @Override
    public boolean deleteOperator(Long id) {
        if (operatorRepository.existsById(id)) {
            operatorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
