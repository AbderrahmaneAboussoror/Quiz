package com.AbderrahmaneAboussoror.quizz.beans;

import com.AbderrahmaneAboussoror.quizz.beans.Quiz.RequestQuizBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public final class TrainerBean extends UserBean {
    private int id;
    private String speciality;
    List<RequestQuizBean> quizList;
}
