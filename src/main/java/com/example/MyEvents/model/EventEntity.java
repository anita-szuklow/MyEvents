package com.example.MyEvents.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    LocalDate date;
    int capacity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    LocationEntity location;
    @OneToMany(mappedBy = "eventEntity")
    Set<RegistrationEntity> registrationEntities;

    public EventEntity(Long id, String name, String description, LocalDate date, int capacity, LocationEntity location, Set<RegistrationEntity> registrationEntities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.capacity = capacity;
        this.location = location;
        this.registrationEntities = registrationEntities;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public EventEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<RegistrationEntity> getRegistrationEntities() {
        return registrationEntities;
    }

    public void setRegistrationEntities(Set<RegistrationEntity> registrationEntities) {
        this.registrationEntities = registrationEntities;
    }
}
