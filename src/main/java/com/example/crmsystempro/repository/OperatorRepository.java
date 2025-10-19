package com.example.crmsystempro.repository;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Operators;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operators, Long> {
}
