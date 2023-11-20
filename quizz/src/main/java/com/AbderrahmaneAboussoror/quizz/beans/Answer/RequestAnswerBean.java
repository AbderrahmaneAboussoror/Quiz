package com.AbderrahmaneAboussoror.quizz.beans.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAnswerBean {
    private int id;
    private int assignQuizId;
    private int validationId;
}
