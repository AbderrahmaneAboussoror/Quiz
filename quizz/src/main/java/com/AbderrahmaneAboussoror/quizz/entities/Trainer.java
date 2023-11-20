package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
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

@Inheritance
@Entity
public final class Trainer extends User{
    @Id
    @SequenceGenerator(
            name = "trainer_id_sequence",
            sequenceName = "trainer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainer_id_sequence"
    )
    private int id;
    private String speciality;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Quiz> quizList;
}
