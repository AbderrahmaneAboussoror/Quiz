package com.AbderrahmaneAboussoror.quizz.beans.Validation;

import com.AbderrahmaneAboussoror.quizz.beans.Answer.RequestAnswerBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.ResponseBean;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ValidationBean {
    private int id;
    private ResponseBean response;
    private RequestQuestionBean question;
    @NotNull(message = "A value is required!")
    private double points;
    private List<RequestAnswerBean> answerList;

}
