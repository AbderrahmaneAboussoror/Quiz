package com.AbderrahmaneAboussoror.quizz.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ValidationBean {
    private int id;
    private ResponseBean response;
    private QuestionBean question;
    @NotNull(message = "A value is required!")
    private double points;

}
