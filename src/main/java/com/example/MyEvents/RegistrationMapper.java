package com.example.MyEvents;

import com.example.MyEvents.dto.Event;
import com.example.MyEvents.dto.Participant;
import com.example.MyEvents.dto.Registration;
import com.example.MyEvents.model.EventEntity;
import com.example.MyEvents.model.ParticipantEntity;
import com.example.MyEvents.model.RegistrationEntity;

public class RegistrationMapper {
    public static Registration toDto(RegistrationEntity entity){
        Event event = EventMapper.toDto(entity.getEventEntity());
        Participant participant = ParticipantMapper.toDto(entity.getParticipantEntity());
        return new Registration(entity.getId(), event, participant, entity.getRegistrationDate());
    }
    public static RegistrationEntity toEntity(Registration registration){
        EventEntity eventEntity = EventMapper.toEntity(registration.getEvent());
        ParticipantEntity participantEntity = ParticipantMapper.toEntity(registration.getParticipant());
        return new RegistrationEntity(registration.getId(), eventEntity, participantEntity, registration.getRegistrationDate());
    }
}
