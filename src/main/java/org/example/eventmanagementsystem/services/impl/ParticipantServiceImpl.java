package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.entities.Participant;
import org.example.eventmanagementsystem.repositories.ParticipantRepository;
import org.example.eventmanagementsystem.services.ParticipantService;
import org.springframework.stereotype.Service;

import java.util.List;

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
