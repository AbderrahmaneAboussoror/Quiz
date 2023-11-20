package com.AbderrahmaneAboussoror.quizz.beans;

import com.AbderrahmaneAboussoror.quizz.beans.AssignQuiz.RequestAssignQuizBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// Getters, Setters, Constructors, toString
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public final class StudentBean extends UserBean {
    private int id;
    private LocalDate registeredAt;
    private List<RequestAssignQuizBean> assignQuizList;
}
