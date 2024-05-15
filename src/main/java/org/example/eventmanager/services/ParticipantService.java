package org.example.eventmanager.services;

import org.example.eventmanager.entities.Participant;

public interface ParticipantService {
    //ParticipantResponse createParticipant(ParticipantRequest participantRequestDTO);
    //List<ParticipantResponse> getAllParticipants();
    //ParticipantResponse getParticipantById(Long participantId);
    //void deleteParticipant(Long participantId);
    Participant save(Participant participant);
    boolean existsByEmail(String email);
}
