package com.AbderrahmaneAboussoror.quizz.beans.Quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestQuizBean {
    private int id;
    private int score;
    private Boolean showResponses;
    private Boolean showResult;
    private int numberOfChances;
    private String remarks;
    private LocalTime duration;
    private int trainerId;
}
