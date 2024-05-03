package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.ParticipantRequest;
import org.example.eventmanagementsystem.dto.response.ParticipantResponse;
import org.example.eventmanagementsystem.entities.Participant;

import java.util.List;

public interface ParticipantService {
    //ParticipantResponse createParticipant(ParticipantRequest participantRequestDTO);
    //List<ParticipantResponse> getAllParticipants();
    //ParticipantResponse getParticipantById(Long participantId);
    //void deleteParticipant(Long participantId);
    Participant save(Participant participant);
    boolean existsByEmail(String email);
}
