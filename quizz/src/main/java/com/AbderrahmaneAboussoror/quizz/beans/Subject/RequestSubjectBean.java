package com.AbderrahmaneAboussoror.quizz.beans.Subject;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSubjectBean {
    protected int id;
    @NotBlank(message = "The title must at least have a non-whitespace character!")
    protected String title;
    protected int parentId;
    protected RequestSubjectBean parent;
}
