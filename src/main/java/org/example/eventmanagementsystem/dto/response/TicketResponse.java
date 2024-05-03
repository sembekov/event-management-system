package org.example.eventmanagementsystem.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TicketResponse {
    @JsonProperty("ticket_id")
    private Long ticketId;

    @JsonProperty("cost")
    private Long cost;

    @JsonProperty("event_id")
    private Long eventId;
}
