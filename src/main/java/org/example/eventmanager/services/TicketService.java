package org.example.eventmanager.services;

import org.example.eventmanager.dto.request.TicketRequest;
import org.example.eventmanager.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse createTicket(TicketRequest ticketRequestDTO);
    List<TicketResponse> getAllTickets();
    TicketResponse getTicketById(Long ticketId);
    void deleteTicket(Long ticketId);
}
