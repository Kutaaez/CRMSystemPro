package com.example.crmsystempro.services.impl;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.repository.ApplicationRequestRepository;
import com.example.crmsystempro.repository.OperatorRepository;
import com.example.crmsystempro.services.ApplicationRequestService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ApplicationRequestServiceImpl implements ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository requestRepository;

    @Autowired
    private OperatorRepository operatorRepository;

    @Override
    public List<ApplicationRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getNewRequests() {
        return requestRepository.findAllByHandledIsFalse();
    }

    @Override
    public List<ApplicationRequest> getProcessedRequests() {
        return requestRepository.findAllByHandledIsTrue();
    }

    @Override
    public ApplicationRequest getRequestById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public ApplicationRequest addRequest(ApplicationRequest request) {
        request.setHandled(false);
        return requestRepository.save(request);
    }

    @Override
    public void processRequest(Long id) {
        ApplicationRequest request = getRequestById(id);
        if (request != null) {
            request.setHandled(true);
            requestRepository.save(request);
        }
    }

    @Override
    public boolean deleteRequest(Long id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ApplicationRequest assignOperators(Long requestId, Long operatorId) {
        ApplicationRequest request = requestRepository.findById(requestId).orElse(null);
        Operators operator = operatorRepository.findById(operatorId).orElse(null);
        if (request != null && operator != null) {
            request.getOperators().add(operator);
            request.setHandled(true);
            return requestRepository.save(request);
        }
        return null;
    }

    @Override
    public void removeOperatorFromRequest(Long requestId, Long operatorId) {
        ApplicationRequest request = getRequestById(requestId);
        if (request != null) {
            request.getOperators().removeIf(op -> op.getId().equals(operatorId));
            requestRepository.save(request);
        }
    }

    @Override
    public ApplicationRequest updateRequest(Long id, ApplicationRequest requestData) {
        ApplicationRequest existingRequest = requestRepository.findById(id).orElse(null);
        if (existingRequest != null) {
            existingRequest.setUserName(requestData.getUserName());
            existingRequest.setCommentary(requestData.getCommentary());
            existingRequest.setPhone(requestData.getPhone());
            existingRequest.setCourse(requestData.getCourse());
            existingRequest.setHandled(requestData.isHandled());
            return requestRepository.save(existingRequest);
        }
        return null;
    }
}
