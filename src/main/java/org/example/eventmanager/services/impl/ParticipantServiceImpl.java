package org.example.eventmanager.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanager.entities.Participant;
import org.example.eventmanager.repositories.ParticipantRepository;
import org.example.eventmanager.services.ParticipantService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public boolean existsByEmail(String email) {
        return participantRepository.existsByEmail(email);
    }
}
