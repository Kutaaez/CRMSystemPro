package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.Operators;
import java.util.List;

public interface OperatorService {
    // егор крид
    Operators addOperator(Operators operator);

    // егор рид
    List<Operators> getAllOperators();
    Operators getOperatorById(Long id);

    // егор апдейт
    Operators updateOperator(Long id, Operators operator);

    // егор делит
    boolean deleteOperator(Long id);


    //егор іба чотко
}
