package com.example.MyEvents.dto;

import java.time.LocalDate;

public class Registration {
    private Long id;
    private Event event;
    private Participant participant;
    private LocalDate registrationDate;

    public Registration(){}

    public Registration(Long id, Event event, Participant participant, LocalDate registrationDate) {
        this.id = id;
        this.event = event;
        this.participant = participant;
        this.registrationDate = registrationDate;
    }
}
