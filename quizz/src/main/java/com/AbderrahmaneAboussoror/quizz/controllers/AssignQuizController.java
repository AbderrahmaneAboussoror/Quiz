package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.AssignQuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/assignQuiz")
public class AssignQuizController {
    private final AssignQuizService assignQuizService;

    public AssignQuizController(AssignQuizService assignQuizService) {
        this.assignQuizService = assignQuizService;
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("assigned quizzes", assignQuizService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("assigned quiz", assignQuizService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestAssignQuizBean bean) {
        Map<String, Object> result = new HashMap<>();
        result.put("assignQuiz", assignQuizService.save(bean));
        result.put("message", "quiz assigned successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody RequestAssignQuizBean bean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("assignQuiz", assignQuizService.update(id, bean));
        result.put("message", "assigned quiz updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (assignQuizService.delete(id)){
            result.put("message", "assigned quiz deleted successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new Exception("assigned quiz not deleted!!!");
    }
}
