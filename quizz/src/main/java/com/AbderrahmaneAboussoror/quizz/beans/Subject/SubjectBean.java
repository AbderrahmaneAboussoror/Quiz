package com.AbderrahmaneAboussoror.quizz.beans.Subject;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
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
    protected List<RequestSubjectBean> children;
    protected List<RequestQuestionBean> questions;

    public SubjectBean(String title) {
        this.setTitle(title);
    }
}
