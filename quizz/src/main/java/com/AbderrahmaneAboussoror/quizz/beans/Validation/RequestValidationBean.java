package com.AbderrahmaneAboussoror.quizz.beans.Validation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestValidationBean {
    private int id;
    private int responseId;
    private int questionId;
    @NotNull(message = "A value is required!")
    private double points;
}
