package com.example.MyEvents.exception;

public class ParticipantNotFoundException extends RuntimeException{
    public ParticipantNotFoundException(Long id){
        super("Could not find participant with id " + id);
    }
}
