package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.Validation.RequestValidationBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.ValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/validation")
public class ValidationController {
    @Autowired
    private ValidationService validationService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("validations", validationService.findAll());
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("validation", validationService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestValidationBean bean) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("validation", validationService.save(bean));
            result.put("message", "validation created successfully");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/api/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody RequestValidationBean bean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("validation", validationService.update(id, bean));
            result.put("message", "validation updated successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/api/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try{
            if (validationService.delete(id)){
                result.put("message", "validation deleted successfully");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            throw new Exception("validation not deleted!!!");
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
