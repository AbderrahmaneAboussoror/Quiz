package com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion;

import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuizQuestionBean {
    private int id;
    private LocalTime duration;
    private RequestQuizBean quiz;
    private RequestQuestionBean question;
}
