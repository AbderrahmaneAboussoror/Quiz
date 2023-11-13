package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Level {
    @Id
    @SequenceGenerator(
            name = "level_id_sequence",
            sequenceName = "level_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "level_id_sequence"
    )
    private int id;
    @Column(nullable = false)
    @NotBlank(message = "A description is required!")
    private String description;
    @Column(nullable = false)
    @Min(value = 0, message = "The minimum value is 0!")
    private double minPoints;
    @Column(nullable = false)
    @Min(value = 0, message = "The minimum value is 0!")
    private double maxPoints;
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

    public Level(String desc,
                 double min,
                 double max) {
        this.setDescription(desc);
        this.setMinPoints(min);
        this.setMaxPoints(max);
    }
}
