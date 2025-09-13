package com.example.MyEvents.controller;

import com.example.MyEvents.dto.Event;
import com.example.MyEvents.exception.EventNotFoundException;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.repository.EventRepository;
import com.example.MyEvents.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateBook(@PathVariable Long id, @RequestBody Event updatedEvent){
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        eventService.deleteEvent(id);
    }
}
