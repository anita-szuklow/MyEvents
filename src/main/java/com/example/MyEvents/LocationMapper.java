package com.example.MyEvents;

import com.example.MyEvents.dto.Event;
import com.example.MyEvents.dto.Location;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.model.LocationEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {
    public static Location toDto(LocationEntity entity){
        List<Event> events = entity.getEvents()
                .stream()
                .map(EventMapper::toDto)
                .collect(Collectors.toList());
        return new Location(entity.getId(), entity.getName(), entity.getCity(), entity.getAddress(), events);
    }

    public static LocationEntity toEntity(Location location){
        List<EventEntity> eventEntities = location.getEvents()
                .stream()
                .map(EventMapper::toEntity)
                .collect(Collectors.toList());
        return new LocationEntity(location.getId(), location.getName(), location.getCity(), location.getAddress(), eventEntities);
    }

//    public static List<LocationEntity> toEntityLisy(List<Location> locations){
//        return new List<LocationEntity>();
    // zastanowić się, jak zrobić tutaj mapowanie typów
//    }
}
