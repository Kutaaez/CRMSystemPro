package com.example.crmsystempro.api;

import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.services.impl.ApplicationRequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/requests")
public class ApplicationRequestController {
    private final ApplicationRequestServiceImpl ars;

    @GetMapping
    public List<ApplicationRequest> getAllRequests() {
        return ars.getAllRequests();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationRequest> getRequestById(@PathVariable Long id) {
        ApplicationRequest request = ars.getRequestById(id);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApplicationRequest> addRequest(@RequestBody ApplicationRequest newRequest) {
        ApplicationRequest createdRequest = ars.addRequest(newRequest);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationRequest> updateRequest(@PathVariable(value = "id") Long id, @RequestBody ApplicationRequest request) {
        ApplicationRequest updatedRequest = ars.updateRequest(id, request);
        if (Objects.isNull(updatedRequest)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedRequest);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable(value = "id") Long id) {
        if (ars.deleteRequest(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
