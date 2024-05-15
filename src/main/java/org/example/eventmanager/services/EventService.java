package org.example.eventmanager.services;

import org.example.eventmanager.dto.request.EventRequest;
import org.example.eventmanager.dto.response.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequestDTO);
    List<EventResponse> getAllEvents();
    EventResponse getEventById(Long eventId);
    void deleteEvent(Long eventId);
}
