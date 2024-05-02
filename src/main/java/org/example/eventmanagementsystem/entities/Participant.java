package org.example.eventmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Table(name = "participant")
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
