package org.example.eventmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Table(name = "event")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_author")
    private String eventAuthor;

    @Column(name = "event_time")
    private Date eventTime;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
