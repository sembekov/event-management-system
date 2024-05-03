package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    boolean existsByEmail(String email);
    Participant save(Participant participant);
}
