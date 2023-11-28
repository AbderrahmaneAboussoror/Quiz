package com.AbderrahmaneAboussoror.quizz.beans.Media;

import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaBean {
    private int id;
    @NotBlank(message = "the content should not be blank!")
    private String url;
    @NotBlank(message = "The type field cannot be blank!")
    private MediaType mediaType;
    private RequestQuestionBean question;
}