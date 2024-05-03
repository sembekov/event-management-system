package org.example.eventmanagementsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.TicketRequest;
import org.example.eventmanagementsystem.dto.response.TicketResponse;
import org.example.eventmanagementsystem.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/add-ticket")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketRequest ticketRequestDTO) {
        TicketResponse newTicket = ticketService.createTicket(ticketRequestDTO);
        return ResponseEntity.status(201).body(newTicket);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        List<TicketResponse> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable("id") Long ticketId) {
        TicketResponse ticket = ticketService.getTicketById(ticketId);
        return ResponseEntity.ok(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }
}
