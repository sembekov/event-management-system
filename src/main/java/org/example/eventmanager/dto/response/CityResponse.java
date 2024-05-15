package org.example.eventmanager.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityResponse {
    @JsonProperty("city_id")
    private Long cityId;

    @JsonProperty("city_name")
    private String cityName;
}
