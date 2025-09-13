package com.example.MyEvents.repository;

import com.example.MyEvents.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
