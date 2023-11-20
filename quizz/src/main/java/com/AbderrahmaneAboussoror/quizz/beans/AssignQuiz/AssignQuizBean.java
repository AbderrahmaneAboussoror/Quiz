package com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz;

import com.AbderrahmaneAboussoror.quizz.beans.Answer.RequestAnswerBean;
import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import com.AbderrahmaneAboussoror.quizz.beans.StudentBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AssignQuizBean {
    private int id;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private int score;
    private String result;
    private RequestQuizBean quiz;
    private StudentBean student;
    private List<RequestAnswerBean> answerList;
}
