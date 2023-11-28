package com.AbderrahmaneAboussoror.quizz.beans.Question;

import com.AbderrahmaneAboussoror.quizz.beans.LevelBean;
import com.AbderrahmaneAboussoror.quizz.beans.Media.MediaBean;
import com.AbderrahmaneAboussoror.quizz.beans.Subject.RequestSubjectBean;
import com.AbderrahmaneAboussoror.quizz.beans.Validation.ValidationBean;
import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class QuestionBean {
    private int id;
    @Min(value = 1, message = "The number of responses of a question should be at least 1!")
    private int numberOfResponses;
    @Min(value = 1, message = "The number of answers of a question should be at least 1!")
    private int numberOfCorrectAnswers;
    @NotBlank(message = "the content should not be blank!")
    private String content;
    @NotBlank(message = "The type field cannot be blank!")
    private ResponseType typeQuestion;
    @Min(value = 0, message = "Value cannot be negative!")
    private double points;
    private RequestSubjectBean subject;
    private LevelBean level;
    private List<ValidationBean> validationList;
    private List<MediaBean> mediaList;

    public QuestionBean(int numOfQuestions,
                    int numOfCorrectAnswers,
                    String content,
                    ResponseType responseType,
                    double points) {
        this.setNumberOfResponses(numOfQuestions);
        this.setNumberOfCorrectAnswers(numOfCorrectAnswers);
        this.setContent(content);
        //this.setType(responseType);
        this.setPoints(points);
    }
}
