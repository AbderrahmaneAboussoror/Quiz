package com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestAssignQuizBean {
    private int id;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private int score;
    private String result;
    private int quizId;
    private int studentId;
}
