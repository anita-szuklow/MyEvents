package com.example.MyEvents.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_entity_id")
    private EventEntity eventEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_entity_id")
    private ParticipantEntity participantEntity;
    private LocalDate registrationDate;

    public RegistrationEntity() {}

    public RegistrationEntity(Long id, EventEntity eventEntity, ParticipantEntity participantEntity, LocalDate registrationDate) {
        this.id = id;
        this.eventEntity = eventEntity;
        this.registrationDate = registrationDate;
        this.participantEntity = participantEntity;
    }

    public ParticipantEntity getParticipantEntity() {
        return participantEntity;
    }

    public void setParticipantEntity(ParticipantEntity participantEntity) {
        this.participantEntity = participantEntity;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
