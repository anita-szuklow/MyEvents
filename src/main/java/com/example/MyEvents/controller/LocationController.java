package com.example.MyEvents.controller;

import com.example.MyEvents.dto.Location;
import com.example.MyEvents.model.LocationEntity;
import com.example.MyEvents.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }
    @GetMapping("/{id}")
    public Location getLocationById(Long id){
        return locationService.getLocationById(id);
    }
    @PostMapping
    public Location addLocation(@RequestBody Location location){
        return locationService.addLocation(location);
    }
    @PutMapping("/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location){
        return locationService.updateLocation(id, location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id){
        locationService.deleteLocation(id);
    }
}
