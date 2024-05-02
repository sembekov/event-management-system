package org.example.eventmanagementsystem.repositories;

import org.example.eventmanagementsystem.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
