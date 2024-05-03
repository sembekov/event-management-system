package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.EventRequest;
import org.example.eventmanagementsystem.dto.response.EventResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventRequest eventRequestDTO);
    Page<EventResponse> getAllEvents(Pageable pageable);
    EventResponse getEventById(Long eventId);
    void deleteEvent(Long eventId);
}
