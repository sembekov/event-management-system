package org.example.eventmanagementsystem.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.request.CityRequest;
import org.example.eventmanagementsystem.dto.response.CityResponse;
import org.example.eventmanagementsystem.services.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping("/add-city")
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequestDTO) {
        CityResponse newCity = cityService.createCity(cityRequestDTO);
        return ResponseEntity.status(201).body(newCity);  // HTTP статус 201 - создано
    }

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities() {
        List<CityResponse> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);  // HTTP статус 200 - ок
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable("id") Long cityId) {
        CityResponse city = cityService.getCityById(cityId);
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Long cityId) {
        cityService.deleteCity(cityId);
        return ResponseEntity.noContent().build();  // HTTP статус 204 - нет содержимого
    }
}
