package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.EventRequest;
import org.example.eventmanagementsystem.dto.response.EventResponse;
import org.example.eventmanagementsystem.entities.City;
import org.example.eventmanagementsystem.entities.Event;
import org.example.eventmanagementsystem.repositories.EventRepository;
import org.example.eventmanagementsystem.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        event.setCity(new City());

        Event savedEvent = eventRepository.save(event);
        return mapToResponse(savedEvent);
    }

    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(this::mapToEventResponse)
                .collect(Collectors.toList());
    }

    private EventResponse mapToEventResponse(Event event) {
        EventResponse response = new EventResponse();
        response.setEventId(event.getId());
        response.setEventName(event.getEventName());
        response.setEventAuthor(event.getEventAuthor());
        response.setEventTime(event.getEventTime());
        response.setLocation(event.getLocation());
        return response;
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
