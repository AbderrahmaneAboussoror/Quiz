package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.Answer.RequestAnswerBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.AnswerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("answers", answerService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("answer", answerService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestAnswerBean bean) {
        Map<String, Object> result = new HashMap<>();
        result.put("answer", answerService.save(bean));
        result.put("message", "answer created successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody RequestAnswerBean bean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("answer", answerService.update(id, bean));
        result.put("message", "answer updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (answerService.delete(id)){
            result.put("message", "answer deleted successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new Exception("answer not deleted!!!");
    }
}
