package com.AbderrahmaneAboussoror.quizz.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserBean {
    protected String firstname;
    protected String lastname;
    protected LocalDate birthdate;
    protected String address;
}
