package com.example.crmsystempro.repository;

import com.example.crmsystempro.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<ApplicationRequest, Long> {
}
