package org.example.eventmanagementsystem.services;

import org.example.eventmanagementsystem.dto.request.CityRequest;
import org.example.eventmanagementsystem.dto.response.CityResponse;
import java.util.List;

public interface CityService {
    CityResponse createCity(CityRequest cityRequestDTO);
    List<CityResponse> getAllCities();
    CityResponse getCityById(Long cityId);
    void deleteCity(Long cityId);
}
