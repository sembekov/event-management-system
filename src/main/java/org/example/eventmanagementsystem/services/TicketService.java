package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.TicketRequest;
import org.example.eventmanagementsystem.dto.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse createTicket(TicketRequest ticketRequestDTO);
    List<TicketResponse> getAllTickets();
    TicketResponse getTicketById(Long ticketId);
    void deleteTicket(Long ticketId);
}
