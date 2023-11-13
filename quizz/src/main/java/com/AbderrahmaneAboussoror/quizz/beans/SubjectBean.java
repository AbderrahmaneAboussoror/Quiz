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

public class SubjectBean {
    protected int id;
    @NotBlank(message = "The title must at least have a non-whitespace character!")
    protected String title;
    protected SubjectBean parentSubject;
    protected List<SubjectBean> children;
    protected List<QuestionBean> questions;

    public SubjectBean(String title) {
        this.setTitle(title);
    }
}
