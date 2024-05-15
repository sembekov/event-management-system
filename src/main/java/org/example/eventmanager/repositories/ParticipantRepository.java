package org.example.eventmanager.repositories;

import org.example.eventmanager.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    boolean existsByEmail(String email);
    Participant save(Participant participant);
}
