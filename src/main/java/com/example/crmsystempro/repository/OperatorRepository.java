package com.example.crmsystempro.repository;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OperatorRepository extends JpaRepository<Operators, Long> {

}
