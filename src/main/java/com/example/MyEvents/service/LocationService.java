package com.example.MyEvents.service;

import com.example.MyEvents.EventMapper;
import com.example.MyEvents.LocationMapper;
import com.example.MyEvents.dto.Location;
import com.example.MyEvents.exception.LocationNotFoundException;
import com.example.MyEvents.model.LocationEntity;
import com.example.MyEvents.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private LocationRepository locationRepository;
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDto)
                .collect(Collectors.toList());
    }

    public Location getLocationById(Long id){
        LocationEntity entity = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        return LocationMapper.toDto(entity);
    }

    public Location addLocation(Location location){
        LocationEntity entity = LocationMapper.toEntity(location);
        LocationEntity saved = locationRepository.save(entity);
        return LocationMapper.toDto(saved);
    }

    public Location updateLocation(Long id, Location location){
        LocationEntity entity = locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException(id));
        entity.setName(location.getName());
        entity.setCity(location.getCity());
        entity.setAddress(location.getAddress());
        entity.setEvents(location.getEvents()
                .stream()
                .map(EventMapper::toEntity)
                .collect(Collectors.toList()));
        return LocationMapper.toDto(locationRepository.save(entity));
    }

    public void deleteLocation(Long id){
        locationRepository.deleteById(id);
    }
}
