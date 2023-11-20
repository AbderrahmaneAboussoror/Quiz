package com.AbderrahmaneAboussoror.quizz.beans;

import com.AbderrahmaneAboussoror.quizz.beans.Question.QuestionBean;
import com.AbderrahmaneAboussoror.quizz.beans.Question.RequestQuestionBean;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LevelBean {
    private int id;
    @NotBlank(message = "A description is required!")
    private String description;
    @Min(value = 0, message = "The minimum value is 0!")
    private double minPoints;
    @Min(value = 0, message = "The minimum value is 0!")
    private double maxPoints;
    private List<RequestQuestionBean> questions;

    public LevelBean(String desc,
                     double min,
                     double max) {
        this.setDescription(desc);
        this.setMinPoints(min);
        this.setMaxPoints(max);
    }
}
