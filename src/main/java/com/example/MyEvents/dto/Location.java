package com.example.MyEvents.dto;

import java.util.List;

public class Location {
    private Long id;
    private String name;
    private String city;
    private String address;
    private List<Event> events;

    public Location() {}

    public Location(Long id, String name, String city, String address, List<Event> events) {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
