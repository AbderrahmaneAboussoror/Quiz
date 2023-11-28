package com.AbderrahmaneAboussoror.quizz.beans.Answer;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.RequestValidationBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerBean {
    private int id;
    private RequestAssignQuizBean assignQuiz;
    private RequestValidationBean validation;
}
