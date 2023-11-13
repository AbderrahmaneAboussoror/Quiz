package com.AbderrahmaneAboussoror.quizz.beans;

import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaBean {
    private int id;
    private MediaType mediaType;
    private QuestionBean question;
}
