package com.example.MyEvents;

import com.example.MyEvents.dto.Event;
import com.example.MyEvents.dto.Location;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.model.LocationEntity;

public class EventMapper {

    public static EventEntity toEntity(Event event){
        LocationEntity locationEntity = LocationMapper.toEntity(event.getLocation());
        return new EventEntity(event.getId(), event.getName(), event.getDescription(), locationEntity);
    }

    public static Event toDto(EventEntity eventEntity){
        Location location = LocationMapper.toDto(eventEntity.getLocation());
        return new Event(eventEntity.getId(), eventEntity.getName(), eventEntity.getDescription(), location);
    }
}
