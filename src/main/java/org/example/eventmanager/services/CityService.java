package org.example.eventmanager.services;

import org.example.eventmanager.dto.request.CityRequest;
import org.example.eventmanager.dto.response.CityResponse;
import java.util.List;

public interface CityService {
    CityResponse createCity(CityRequest cityRequestDTO);
    List<CityResponse> getAllCities();
    CityResponse getCityById(Long cityId);
    void deleteCity(Long cityId);
}
