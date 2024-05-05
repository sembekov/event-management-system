package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
