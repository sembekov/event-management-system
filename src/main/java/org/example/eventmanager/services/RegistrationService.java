package org.example.eventmanager.services;

import org.example.eventmanager.dto.request.RegistrationRequest;
import org.example.eventmanager.dto.response.ParticipantResponse;

public interface RegistrationService {
    ParticipantResponse register(RegistrationRequest registrationRequest);
}
