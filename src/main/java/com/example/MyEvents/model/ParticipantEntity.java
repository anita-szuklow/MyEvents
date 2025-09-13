package com.example.MyEvents.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ParticipantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany
    private Set<RegistrationEntity> registrations;

    public ParticipantEntity(){}

    public ParticipantEntity(Long id, String name, String email, Set<RegistrationEntity> registrations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrations = registrations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RegistrationEntity> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<RegistrationEntity> registrations) {
        this.registrations = registrations;
    }
}
