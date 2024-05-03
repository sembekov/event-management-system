package org.example.eventmanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
public class EventResponse {
    @JsonProperty("event_id")
    private Long eventId;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_author")
    private String eventAuthor;

    @JsonProperty("event_time")
    private Date eventTime;

    @JsonProperty("location")
    private String location;

    @JsonProperty("city_id")
    private Long cityId;
}
