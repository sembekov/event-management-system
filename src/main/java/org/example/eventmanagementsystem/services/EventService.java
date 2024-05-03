package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.EventRequest;
import org.example.eventmanagementsystem.dto.response.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequestDTO);
    List<EventResponse> getAllEvents();
    EventResponse getEventById(Long eventId);
    void deleteEvent(Long eventId);
}
