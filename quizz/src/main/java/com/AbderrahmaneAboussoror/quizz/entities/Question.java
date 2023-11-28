package com.AbderrahmaneAboussoror.quizz.entities;

import com.AbderrahmaneAboussoror.quizz.enums.ResponseType;
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
public class Question {
    @Id
    @SequenceGenerator(
            name = "question_id_sequence",
            sequenceName = "question_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_id_sequence"
    )
    private int id;
    @Column(nullable = false)
    @Min(value = 1, message = "The number of responses of a question should be at least 1!")
    private int numberOfResponses;
    @Column(nullable = false)
    @Min(value = 1, message = "The number of answers of a question should be at least 1!")
    private int numberOfCorrectAnswers;
    @Column(nullable = false, length = 100)
    @NotBlank(message = "the content should not be blank!")
    private String content;
    @Enumerated(EnumType.STRING)
    private ResponseType typeQuestion;
    @Column(nullable = false)
    @Min(value = 0, message = "Value cannot be negative!")
    private double points;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Media> mediaList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Validation> validationList;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestionList;

    public Question(int numOfResponses,
                    int numOfCorrectAnswers,
                    String content,
                    ResponseType responseType,
                    double points) {
        this.setNumberOfResponses(numOfResponses);
        this.setNumberOfCorrectAnswers(numOfCorrectAnswers);
        this.setContent(content);
        //this.setType(responseType);
        this.setPoints(points);
    }
}
