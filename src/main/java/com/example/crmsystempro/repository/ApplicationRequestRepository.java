package com.example.crmsystempro.repository;

import com.example.crmsystempro.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandledIsTrue();
        List<ApplicationRequest> findAllByHandledIsFalse();
    List<ApplicationRequest> findByHandledOrderByIdDesc(boolean handled);
    List<ApplicationRequest> findAllByOrderByIdDesc();
}