package org.example.eventmanagementsystem.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagementsystem.dto.response.CityResponse;
import org.example.eventmanagementsystem.dto.request.CityRequest;
import org.example.eventmanagementsystem.entities.City;
import org.example.eventmanagementsystem.repositories.CityRepository;
import org.example.eventmanagementsystem.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public CityResponse createCity(CityRequest cityRequestDTO) {
        City city = new City();
        city.setCityName(cityRequestDTO.getCityName());

        City savedCity = cityRepository.save(city);
        return mapToResponse(savedCity);
    }

    @Override
    public List<CityResponse> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CityResponse getCityById(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("City not found"));
        return mapToResponse(city);
    }

    @Override
    public void deleteCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IllegalArgumentException("City not found"));
        cityRepository.delete(city);
    }

    private CityResponse mapToResponse(City city) {
        CityResponse cityResponseDTO = new CityResponse();
        cityResponseDTO.setCityId(city.getId());
        cityResponseDTO.setCityName(city.getCityName());
        return cityResponseDTO;
    }
}
