package com.example.MyEvents.exception;

public class RegistrationNotFoundException extends RuntimeException{
    public RegistrationNotFoundException(Long id){
        super("Could not find registration with id " + id);
    }
}
