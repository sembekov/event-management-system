package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.ParticipantRequest;
import org.example.eventmanagementsystem.dto.response.ParticipantResponse;
import java.util.List;

public interface ParticipantService {
    ParticipantResponse createParticipant(ParticipantRequest participantRequestDTO);
    List<ParticipantResponse> getAllParticipants();
    ParticipantResponse getParticipantById(Long participantId);
    void deleteParticipant(Long participantId);
}
