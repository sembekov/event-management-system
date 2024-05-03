package org.example.eventmanagementsystem.dto.request;

import lombok.Data;

import java.sql.Date;

@Data
public class EventRequest {
    private String eventName;
    private String eventAuthor;
    private Date eventTime;
    private String location;
    private Long cityId;
}