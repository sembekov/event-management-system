package org.example.eventmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "ticket")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "cost")
    private Long cost;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
