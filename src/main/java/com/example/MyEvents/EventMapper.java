package com.example.MyEvents;

import com.example.MyEvents.dto.Event;
import com.example.MyEvents.dto.Location;
import com.example.MyEvents.exception.LocationNotFoundException;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.model.LocationEntity;
import com.example.MyEvents.repository.LocationRepository;

import java.util.stream.Collectors;

public class EventMapper {
    private static LocationRepository locationRepository;
    public static EventEntity toEntity(Event event, LocationEntity byId){
//        LocationEntity locationEntity = LocationMapper.toEntity(event.getLocation());
        return new EventEntity(event.getId(), event.getName(), event.getDescription(), event.getDate(), event.getCapacity(), byId,
                event.getRegistrations()
                        .stream()
                        .map(RegistrationMapper::toEntity)
                        .collect(Collectors.toSet())
        );
    }

    public static EventEntity toEntity(Event event){
        return new EventEntity(event.getId(), event.getName(), event.getDescription(), event.getDate(), event.getCapacity(),
                locationRepository.findById(event.getLocationId()).orElseThrow(() -> new LocationNotFoundException(event.getLocationId())),
                event.getRegistrations()
                        .stream()
                        .map(RegistrationMapper::toEntity)
                        .collect(Collectors.toSet())
        );
    }

    public static Event toDto(EventEntity eventEntity){
//        Location location = LocationMapper.toDto(eventEntity.getLocation());
        return new Event(eventEntity.getId(), eventEntity.getName(), eventEntity.getDescription(), eventEntity.getDate(), eventEntity.getCapacity(), eventEntity.getLocation().getId(),
                eventEntity.getRegistrationEntities()
                        .stream()
                        .map(RegistrationMapper::toDto)
                        .collect(Collectors.toSet()));
    }
}
