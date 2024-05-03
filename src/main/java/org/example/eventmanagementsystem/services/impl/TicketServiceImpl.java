package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.TicketRequest;
import org.example.eventmanagementsystem.dto.response.TicketResponse;
import org.example.eventmanagementsystem.entities.Ticket;
import org.example.eventmanagementsystem.repositories.TicketRepository;
import org.example.eventmanagementsystem.services.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setCost(ticketRequest.getCost());

        Ticket savedTicket = ticketRepository.save(ticket);
        return mapToResponse(savedTicket);
    }

    @Override
    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TicketResponse getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
        return mapToResponse(ticket);
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));
        ticketRepository.delete(ticket);
    }

    private TicketResponse mapToResponse(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setTicketId(ticket.getId());
        response.setCost(ticket.getCost());
        return response;
    }
}
