package com.example.MyEvents.repository;

import com.example.MyEvents.model.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
