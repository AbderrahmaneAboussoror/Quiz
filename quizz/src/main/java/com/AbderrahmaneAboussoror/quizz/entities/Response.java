package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.*;
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
public class Response {
    @Id
    @SequenceGenerator(
            name = "response_id_sequence",
            sequenceName = "response_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "response_id_sequence"
    )
    private int id;
    @Column(nullable = false)
    @NotBlank(message = "The content of the response should not be empty!")
    private String content;
    @OneToMany(mappedBy = "response", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Validation> validationList;

    public Response(String content) {
        this.setContent(content);
    }
}
