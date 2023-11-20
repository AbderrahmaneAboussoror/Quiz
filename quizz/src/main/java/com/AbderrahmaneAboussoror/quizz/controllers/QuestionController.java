package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("questions", questionService.findAll());
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
            result.put("question", questionService.findById(id));
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestQuestionBean questionBean) {
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("question", questionService.save(questionBean));
            result.put("message", "question created successfully");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e) {
            result.put("error",  e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable int id, @Valid @RequestBody RequestQuestionBean questionBean) {
        Map<String, Object> result = new HashMap<>();
        try{
            result.put("question", questionService.update(id, questionBean));
            result.put("message", "question created successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        try{
            if (questionService.delete(id)){
                result.put("message", "question deleted successfully");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            throw new Exception("question not deleted!!!");
        }catch (Exception e) {
            result.put("error", e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
