package org.example.eventmanagementsystem.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TicketRequest {
    @JsonProperty("cost")
    private Long cost;

    @JsonProperty("event_id")
    private Long eventId;
}
