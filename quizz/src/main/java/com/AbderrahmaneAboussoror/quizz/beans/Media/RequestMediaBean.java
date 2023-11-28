package com.AbderrahmaneAboussoror.quizz.beans.Media;

import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMediaBean {
    private int id;

    private String url;
    private MediaType mediaType;
    private int questionId;
}
