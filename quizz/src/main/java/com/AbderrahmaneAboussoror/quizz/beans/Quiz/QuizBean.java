package com.AbderrahmaneAboussoror.quizz.beans.Quiz;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.QuizQuestion.RequestQuizQuestionBean;
import com.AbderrahmaneAboussoror.quizz.entities.Trainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuizBean {
    private int id;
    private int score;
    private Boolean showResponses;
    private Boolean showResult;
    private int numberOfChances;
    private String remarks;
    private LocalTime duration;
    private Trainer trainer;
    private List<RequestAssignQuizBean> assignQuizList;
    private List<RequestQuizQuestionBean> quizQuestionList;
}
