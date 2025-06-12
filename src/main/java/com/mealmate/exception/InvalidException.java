package com.mealmate.exception;

public class InvalidException extends RuntimeException{
    public InvalidException(String massage){
        super(massage);
    }
}
