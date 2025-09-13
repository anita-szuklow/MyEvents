package com.example.MyEvents.controller;

import com.example.MyEvents.dto.Participant;
import com.example.MyEvents.service.ParticipantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService participantService;
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }
    @GetMapping
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    };
    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable Long id){
        return participantService.getParticipantById(id);
    }
    @PostMapping
    public Participant addParticipant(@RequestBody Participant participant){
        return participantService.addParticipant(participant);
    }
    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable Long id, @RequestBody Participant participant){
        return participantService.updateParticipant(id, participant);
    }
    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id){
        participantService.deleteParticipant(id);
    }
}
