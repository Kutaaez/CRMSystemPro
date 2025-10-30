package com.example.crmsystempro.api;
import com.example.crmsystempro.entities.ApplicationRequest;
import com.example.crmsystempro.entities.Operators;
import com.example.crmsystempro.services.impl.ApplicationRequestServiceImpl;
import com.example.crmsystempro.services.impl.OperatorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/operators")
public class OperatorController {

    private final OperatorServiceImpl operatorService;
    private final ApplicationRequestServiceImpl applicationRequestService;

    @GetMapping
    public ResponseEntity<List<Operators>> getOperators() {
        List<Operators> operators = operatorService.getAllOperators();
        if (operators.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(operators, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Operators> getOperator(@PathVariable(value = "id") Long id) {
        Operators operator = operatorService.getOperatorById(id);
        if (Objects.isNull(operator)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(operator);
    }

    @PostMapping
    public ResponseEntity<Operators> addOperator(@RequestBody Operators operator) {
        Operators createdOperator = operatorService.addOperator(operator);
        return new ResponseEntity<>(createdOperator, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Operators> updateOperator(@PathVariable(value = "id") Long id, @RequestBody Operators operator) {
        Operators updatedOperator = operatorService.updateOperator(id, operator);
        if (Objects.isNull(updatedOperator)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(updatedOperator);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOperator(@PathVariable(value = "id") Long id) {
        if (operatorService.deleteOperator(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{operatorId}/assign/{requestId}")
    public ResponseEntity<ApplicationRequest> assignRequest(
            @PathVariable(value = "operatorId") Long operatorId,
            @PathVariable(value = "requestId") Long requestId) {

        ApplicationRequest request = applicationRequestService.assignOperators(requestId, operatorId);
        if (Objects.isNull(request)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(request);
    }
}