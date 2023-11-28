package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_id_sequence",
            sequenceName = "answer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_quiz_id_sequence"
    )
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_quiz_id")
    private AssignQuiz assignQuiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validation_id")
    private Validation validation;
}
