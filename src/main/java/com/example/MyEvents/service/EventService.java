package com.example.MyEvents.service;

import com.example.MyEvents.EventMapper;
import com.example.MyEvents.LocationMapper;
import com.example.MyEvents.RegistrationMapper;
import com.example.MyEvents.dto.Event;
import com.example.MyEvents.exception.EventNotFoundException;
import com.example.MyEvents.exception.LocationNotFoundException;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.model.LocationEntity;
import com.example.MyEvents.repository.EventRepository;
import com.example.MyEvents.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventService(EventRepository eventRepository,  LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
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
        LocationEntity byId = locationRepository.findById(event.getLocationId())
                .orElseThrow(()-> new LocationNotFoundException(event.getLocationId()));
        EventEntity entity = EventMapper.toEntity(event, byId);
        EventEntity saved = eventRepository.save(entity);
        return EventMapper.toDto(saved);
    }

    public Event updateEvent(Long id, Event updatedEvent){
        EventEntity entity = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        LocationEntity locationEntity = locationRepository.findById(updatedEvent.getLocationId())
                        .orElseThrow(() -> new  LocationNotFoundException(updatedEvent.getLocationId()));
        entity.setName(updatedEvent.getName());
        entity.setDescription(updatedEvent.getDescription());
        entity.setDate(updatedEvent.getDate());
        entity.setCapacity(updatedEvent.getCapacity());
        entity.setLocation(locationEntity);
        entity.setRegistrationEntities(updatedEvent.getRegistrations()
                .stream()
                .map(RegistrationMapper::toEntity)
                .collect(Collectors.toSet())
        );

        return EventMapper.toDto(eventRepository.save(entity));
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }
}
