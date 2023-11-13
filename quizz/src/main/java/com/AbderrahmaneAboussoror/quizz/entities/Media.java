package com.AbderrahmaneAboussoror.quizz.entities;

import com.AbderrahmaneAboussoror.quizz.enums.MediaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Media {
    @Id
    @SequenceGenerator(
            name = "media_id_sequence",
            sequenceName = "media_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_id_sequence"
    )
    private int id;
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
