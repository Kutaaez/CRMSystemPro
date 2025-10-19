package com.example.crmsystempro.services;

import com.example.crmsystem.entities.ApplicationRequest;
import com.example.crmsystem.repository.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository requestRepository;

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
}