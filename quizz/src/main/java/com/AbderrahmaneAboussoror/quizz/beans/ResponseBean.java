package com.AbderrahmaneAboussoror.quizz.beans;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseBean {
    private int id;
    @NotBlank(message = "The content of the response should not be empty!")
    private String content;
    private List<ValidationBean> validationList;

    public ResponseBean(String content) {
        this.setContent(content);
    }
}
