package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
