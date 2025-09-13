package com.example.MyEvents.model;

import jakarta.persistence.*;

@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @ManyToOne
    LocationEntity location;

    public EventEntity(Long id, String name, String description, LocationEntity location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
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
}
