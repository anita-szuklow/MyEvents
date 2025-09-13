package com.example.MyEvents.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;
    @OneToMany
    private List<EventEntity> events;

    public LocationEntity() {}

    public LocationEntity(Long id, String name, String city, String address, List<EventEntity> events) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.events = events;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }
}
