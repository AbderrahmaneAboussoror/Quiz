package com.AbderrahmaneAboussoror.quizz.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class QuizQuestion {
    @Id
    @SequenceGenerator(
            name = "quiz_question_id_sequence",
            sequenceName = "quiz_question_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quiz_question_id_sequence"
    )
    private int id;
    private LocalTime duration;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
