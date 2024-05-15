package org.example.eventmanager.repositories;

import org.example.eventmanager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
