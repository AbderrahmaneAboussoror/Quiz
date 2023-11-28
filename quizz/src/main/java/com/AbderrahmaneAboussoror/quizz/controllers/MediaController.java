package com.AbderrahmaneAboussoror.quizz.controllers;

import com.AbderrahmaneAboussoror.quizz.beans.Media.RequestMediaBean;
import com.AbderrahmaneAboussoror.quizz.services.impl.MediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> result = new HashMap<>();
        result.put("medias", mediaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> get(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("media", mediaService.findById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody RequestMediaBean bean) {
        Map<String, Object> result = new HashMap<>();
        result.put("media", mediaService.save(bean));
        result.put("message", "media created successfully");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody RequestMediaBean bean, @PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        result.put("media", mediaService.update(id, bean));
        result.put("message", "media updated successfully");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int id) throws Exception {
        Map<String, Object> result = new HashMap<>();
        if (mediaService.delete(id)){
            result.put("message", "media deleted successfully");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        throw new Exception("media not deleted!!!");
    }
}
