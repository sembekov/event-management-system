package org.example.eventmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.eventmanager.entities.Participant;
import org.example.eventmanager.services.ParticipantService;
import org.example.eventmanager.dto.response.ParticipantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService participantService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ParticipantController(ParticipantService participantService, PasswordEncoder passwordEncoder) {
        this.participantService = participantService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add-participant")
    public ResponseEntity<ParticipantResponse> addParticipant(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password) {

        boolean participantExists = participantService.existsByEmail(email);
        if (participantExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        Participant newParticipant = new Participant();
        newParticipant.setFirstName(firstName);
        newParticipant.setLastName(lastName);
        newParticipant.setEmail(email);
        newParticipant.setUsername(email);
        newParticipant.setPassword(passwordEncoder.encode(password));

        Participant savedParticipant = participantService.save(newParticipant);

        ParticipantResponse response = new ParticipantResponse();
        response.setParticipantId(savedParticipant.getId());
        response.setFirstName(savedParticipant.getFirstName());
        response.setLastName(savedParticipant.getLastName());
        response.setEmail(savedParticipant.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
