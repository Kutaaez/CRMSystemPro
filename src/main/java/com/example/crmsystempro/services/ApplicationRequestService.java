package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.repository.ApplicationRequestRepository;
import com.example.crmsystempro.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository requestRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    public List<ApplicationRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public List<ApplicationRequest> getNewRequests() {
        return requestRepository.findAllByHandledIsFalse();
    }

    public List<ApplicationRequest> getProcessedRequests() {
        return requestRepository.findAllByHandledIsTrue();
    }

    public ApplicationRequest getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    public void addRequest(ApplicationRequest request) {
        request.setHandled(false);
        requestRepository.save(request);
    }

    public void processRequest(Long id) {
        ApplicationRequest request = getRequestById(id);
        if (request != null) {
            request.setHandled(true);
            requestRepository.save(request);
        }
    }

    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
    public void assignOperators(Long requestId, List<Long> operatorIds) {
        ApplicationRequest request = getRequestById(requestId);
        if (request != null) {
            List<Operators> operators = operatorRepository.findAllById(operatorIds);
            request.setOperators(operators);
            request.setHandled(true);
            requestRepository.save(request);
        }
    }

    public void removeOperatorFromRequest(Long requestId, Long operatorId) {
        ApplicationRequest request = getRequestById(requestId);
        if (request != null) {
            request.getOperators().removeIf(op -> op.getId().equals(operatorId));
            requestRepository.save(request);
        }
    }
    public void updateRequest(ApplicationRequest request) {
        ApplicationRequest existingRequest = getRequestById(request.getId());
        if (existingRequest != null) {
            existingRequest.setUserName(request.getUserName());
            existingRequest.setCommentary(request.getCommentary());
            existingRequest.setPhone(request.getPhone());
            existingRequest.setCourses(request.getCourses());
            requestRepository.save(existingRequest);
        }
    }
}