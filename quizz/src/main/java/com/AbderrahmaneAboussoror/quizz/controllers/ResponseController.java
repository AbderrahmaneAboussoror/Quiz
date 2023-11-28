package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.ResponseBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.ResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/response")
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("responses", responseService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("response", responseService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody ResponseBean responseBean) {
        Map<String, Object> result = new HashMap<>();
        result.put("response", responseService.save(responseBean));
        result.put("message", "response created successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody ResponseBean responseBean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("response", responseService.update(id, responseBean));
        result.put("message", "response updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (responseService.delete(id)){
            result.put("message", "response deleted successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new Exception("response not deleted!!!");
    }
}
