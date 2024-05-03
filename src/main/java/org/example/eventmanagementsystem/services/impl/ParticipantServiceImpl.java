package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.ParticipantRequest;
import org.example.eventmanagementsystem.dto.response.ParticipantResponse;
import org.example.eventmanagementsystem.entities.Participant;
import org.example.eventmanagementsystem.repositories.ParticipantRepository;
import org.example.eventmanagementsystem.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;

    @Override
    public ParticipantResponse createParticipant(ParticipantRequest participantRequestDTO) {
        Participant participant = new Participant();
        participant.setFirstName(participantRequestDTO.getFirstName());
        participant.setLastName(participantRequestDTO.getLastName());
        participant.setUsername(participantRequestDTO.getUsername());
        participant.setEmail(participantRequestDTO.getEmail());

        Participant savedParticipant = participantRepository.save(participant);
        return mapToResponse(savedParticipant);
    }

    @Override
    public List<ParticipantResponse> getAllParticipants() {
        return participantRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipantResponse getParticipantById(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found"));
        return mapToResponse(participant);
    }

    @Override
    public void deleteParticipant(Long participantId) {
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found"));
        participantRepository.delete(participant);
    }

    private ParticipantResponse mapToResponse(Participant participant) {
        ParticipantResponse response = new ParticipantResponse();
        response.setParticipantId(participant.getId());
        response.setFirstName(participant.getFirstName());
        response.setLastName(participant.getLastName());
        response.setUsername(participant.getUsername());
        response.setEmail(participant.getEmail());
        return response;
    }
}
