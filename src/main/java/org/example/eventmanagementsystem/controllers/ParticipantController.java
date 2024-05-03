package org.example.eventmanagementsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.ParticipantRequest;
import org.example.eventmanagementsystem.dto.response.ParticipantResponse;
import org.example.eventmanagementsystem.services.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @PostMapping("/add-participant")
    public ResponseEntity<ParticipantResponse> createParticipant(@RequestBody ParticipantRequest participantRequestDTO) {
        ParticipantResponse newParticipant = participantService.createParticipant(participantRequestDTO);
        return ResponseEntity.status(201).body(newParticipant);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantResponse>> getAllParticipants() {
        List<ParticipantResponse> participants = participantService.getAllParticipants();
        return ResponseEntity.ok(participants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantResponse> getParticipantById(@PathVariable("id") Long participantId) {
        ParticipantResponse participant = participantService.getParticipantById(participantId);
        return ResponseEntity.ok(participant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable("id") Long participantId) {
        participantService.deleteParticipant(participantId);
        return ResponseEntity.noContent().build();
    }
}
