package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class AssignQuiz {
    @Id
    @SequenceGenerator(
            name = "assign_quiz_id_sequence",
            sequenceName = "assign_quiz_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "assign_quiz_id_sequence"
    )
    private int id;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private int score;
    private String result;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToMany(mappedBy = "assignQuiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answerList;
}
