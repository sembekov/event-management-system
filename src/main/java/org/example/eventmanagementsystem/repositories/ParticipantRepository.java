package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
