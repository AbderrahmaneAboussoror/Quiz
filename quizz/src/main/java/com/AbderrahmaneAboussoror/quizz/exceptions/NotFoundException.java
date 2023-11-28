package com.AbderrahmaneAboussoror.quizz.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException (String message) {
        super(message);
    }
    public NotFoundException() {
        super("invalid id!!!");
    }
}
