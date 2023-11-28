package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("quizzes", quizService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("quiz", quizService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestQuizBean bean) {
        Map<String, Object> result = new HashMap<>();
        result.put("quiz", quizService.save(bean));
        result.put("message", "quiz created successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody RequestQuizBean bean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("quiz", quizService.update(id, bean));
        result.put("message", "quiz updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (quizService.delete(id)){
            result.put("message", "quiz deleted successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new Exception("quiz not deleted!!!");
    }
}
