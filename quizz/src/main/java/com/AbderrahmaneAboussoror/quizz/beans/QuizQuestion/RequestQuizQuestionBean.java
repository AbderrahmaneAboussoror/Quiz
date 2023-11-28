package com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestQuizQuestionBean {
    private int id;
    private LocalTime duration;
    private int quizId;
    private int questionId;
}
