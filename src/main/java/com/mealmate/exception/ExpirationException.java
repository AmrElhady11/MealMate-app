package com.mealmate.exception;

public class ExpirationException extends RuntimeException{
    public ExpirationException(String massage){
        super(massage);
    }
}
