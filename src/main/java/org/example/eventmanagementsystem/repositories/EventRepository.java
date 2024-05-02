package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
