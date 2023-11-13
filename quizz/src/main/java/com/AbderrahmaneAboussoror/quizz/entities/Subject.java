package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_id_sequence",
            sequenceName = "subject_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_id_sequence"
    )
    protected int id;
    @Column(nullable = false, length = 50)
    protected String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    protected Subject parentSubject;
    @OneToMany(mappedBy = "parentSubject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Subject> children;
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<Question> questions;
    public Subject(String title) {
        this.setTitle(title);
    }
}
