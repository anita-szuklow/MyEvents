package com.example.MyEvents;

import com.example.MyEvents.dto.Participant;
import com.example.MyEvents.model.ParticipantEntity;

import java.util.stream.Collectors;

public class ParticipantMapper {
    public static Participant toDto(ParticipantEntity entity){

        return new Participant(entity.getId(), entity.getName(), entity.getEmail(),
                entity.getRegistrations()
                        .stream()
                        .map(RegistrationMapper::toDto)
                        .collect(Collectors.toSet())
        );
    }

    public static ParticipantEntity toEntity(Participant participant){
        return new ParticipantEntity(participant.getId(), participant.getName(), participant.getEmail(),
                participant.getRegistrations()
                        .stream()
                        .map(RegistrationMapper::toEntity)
                        .collect(Collectors.toSet())

        );
    }
}
