package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.RegistrationRequest;
import org.example.eventmanagementsystem.dto.response.ParticipantResponse;

public interface RegistrationService {
    ParticipantResponse register(RegistrationRequest registrationRequest);
}
