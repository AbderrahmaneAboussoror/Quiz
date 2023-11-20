package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Quiz {
    @Id
    @SequenceGenerator(
            name = "quiz_id_sequence",
            sequenceName = "quiz_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_id_sequence"
    )
    private int id;
    private int score;
    private Boolean showResponses;
    private Boolean showResult;
    private int numberOfChances;
    private String remarks;
    private LocalTime duration;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AssignQuiz> assignQuizList;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizQuestion> quizQuestionList;
}
