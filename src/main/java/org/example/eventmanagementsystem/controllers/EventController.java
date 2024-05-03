package org.example.eventmanagementsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.EventRequest;
import org.example.eventmanagementsystem.dto.response.EventResponse;
import org.example.eventmanagementsystem.services.EventService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/add-event")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequestDTO) {
        EventResponse newEvent = eventService.createEvent(eventRequestDTO);
        return ResponseEntity.status(201).body(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        List<EventResponse> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable("id") Long eventId) {
        EventResponse event = eventService.getEventById(eventId);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
