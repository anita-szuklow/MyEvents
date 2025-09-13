package com.example.MyEvents.service;

import com.example.MyEvents.ParticipantMapper;
import com.example.MyEvents.RegistrationMapper;
import com.example.MyEvents.dto.Participant;
import com.example.MyEvents.exception.ParticipantNotFoundException;
import com.example.MyEvents.model.ParticipantEntity;
import com.example.MyEvents.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    public ParticipantService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }
    public List<Participant> getAllParticipants(){
        return participantRepository.findAll()
                .stream()
                .map(ParticipantMapper::toDto)
                .collect(Collectors.toList());
    }
    public Participant getParticipantById(Long id){
        ParticipantEntity entity = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));
        return ParticipantMapper.toDto(entity);
    }
    public Participant addParticipant(Participant participant){
        ParticipantEntity entity = ParticipantMapper.toEntity(participant);
        ParticipantEntity saved = participantRepository.save(entity);
        return ParticipantMapper.toDto(saved);
    }

    public Participant updateParticipant(Long id, Participant participant){
        ParticipantEntity entity = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));
        entity.setName(participant.getName());
        entity.setEmail(participant.getEmail());
        entity.setRegistrations(participant.getRegistrations()
                .stream()
                .map(RegistrationMapper::toEntity)
                .collect(Collectors.toSet())
        );
        return ParticipantMapper.toDto(participantRepository.save(entity));
    }
    public void deleteParticipant(Long id){
        participantRepository.deleteById(id);
    }
}
