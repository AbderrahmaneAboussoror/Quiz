package com.AbderrahmaneAboussoror.quizz.beans.Question;

import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestQuestionBean {
    private int id;
    @Min(value = 1, message = "The number of responses of a question should be at least 1!")
    private int numberOfResponses;
    @Min(value = 1, message = "The number of answers of a question should be at least 1!")
    private int numberOfCorrectAnswers;
    @NotBlank(message = "the content should not be blank!")
    private String content;
    private ResponseType typeQuestion;
    @Min(value = 0, message = "Value cannot be negative!")
    private double points;
    private int subjectId;
    private int levelId;
}
