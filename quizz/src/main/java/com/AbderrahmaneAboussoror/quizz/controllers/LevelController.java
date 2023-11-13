package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.LevelBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.LevelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("levels", levelService.findAll());
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
            result.put("level", levelService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody LevelBean levelBean) {
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("level", levelService.save(levelBean));
            result.put("message", "level created successfully");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody LevelBean levelBean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("updated level", levelService.update(id, levelBean));
            result.put("message", "level updated successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (levelService.delete(id)){
                result.put("message", "level deleted successfully");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            throw new Exception("level not deleted!!!");
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
