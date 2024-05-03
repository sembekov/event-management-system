package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.EventRequest;
import org.example.eventmanagementsystem.dto.response.EventResponse;
import org.example.eventmanagementsystem.entities.City;
import org.example.eventmanagementsystem.entities.Event;
import org.example.eventmanagementsystem.repositories.EventRepository;
import org.example.eventmanagementsystem.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public EventResponse createEvent(EventRequest eventRequestDTO) {
        Event event = new Event();
        event.setEventName(eventRequestDTO.getEventName());
        event.setEventAuthor(eventRequestDTO.getEventAuthor());
        event.setEventTime(eventRequestDTO.getEventTime());
        event.setLocation(eventRequestDTO.getLocation());
        event.setCity(new City());  // это можно улучшить, используя CityService

        Event savedEvent = eventRepository.save(event);
        return mapToResponse(savedEvent);
    }

    @Override
    public Page<EventResponse> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable).map(this::mapToResponse);
    }

    @Override
    public EventResponse getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return mapToResponse(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        eventRepository.delete(event);
    }

    private EventResponse mapToResponse(Event event) {
        EventResponse eventResponseDTO = new EventResponse();
        eventResponseDTO.setEventId(event.getId());
        eventResponseDTO.setEventName(event.getEventName());
        eventResponseDTO.setEventAuthor(event.getEventAuthor());
        eventResponseDTO.setEventTime(event.getEventTime());
        eventResponseDTO.setLocation(event.getLocation());
        return eventResponseDTO;
    }
}
