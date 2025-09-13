package com.example.MyEvents.service;

import com.example.MyEvents.EventMapper;
import com.example.MyEvents.LocationMapper;
import com.example.MyEvents.dto.Event;
import com.example.MyEvents.exception.EventNotFoundException;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toDto)
                .collect(Collectors.toList());
    }

    public Event getEventById(Long id){
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        return EventMapper.toDto(entity);
    }

    public Event addEvent(Event event){
        EventEntity entity = EventMapper.toEntity(event);
        EventEntity saved = eventRepository.save(entity);
        return EventMapper.toDto(saved);
    }

    public Event updateEvent(Long id, Event updatedEvent){
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        entity.setName(updatedEvent.getName());
        entity.setDescription(updatedEvent.getDescription());
        entity.setLocation(LocationMapper.toEntity(updatedEvent.getLocation()));

        return EventMapper.toDto(eventRepository.save(entity));
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }
}
