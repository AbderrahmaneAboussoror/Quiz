package com.AbderrahmaneAboussoror.quizz.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass
public class User {
    protected String firstname;
    protected String lastname;
    protected LocalDate birthdate;
    protected String address;
}
