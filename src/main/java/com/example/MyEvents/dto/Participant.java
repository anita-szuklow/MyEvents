package com.example.MyEvents.dto;

import java.util.Set;

public class Participant {
    private Long id;
    private String name;
    private String email;
    private Set<Registration> registrations;

    public Participant(){}

    public Participant(Long id, String name, String email, Set<Registration> registrations) {
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

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }
}
