package com.example.crmsystempro.services;

import com.example.crmsystempro.entities.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {

    List<ApplicationRequest> getAllRequests();

    List<ApplicationRequest> getNewRequests();

    List<ApplicationRequest> getProcessedRequests();

    ApplicationRequest getRequestById(Long id);

    ApplicationRequest addRequest(ApplicationRequest request);

    void processRequest(Long id);

    boolean deleteRequest(Long id);

    ApplicationRequest assignOperators(Long requestId, Long operatorId);

    void removeOperatorFromRequest(Long requestId, Long operatorId);


    ApplicationRequest updateRequest(Long id, ApplicationRequest requestData);
}
