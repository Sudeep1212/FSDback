package com.fullstackdev.fsdv1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private Integer eventId;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventFee")
    private Float eventFee;

    // Default constructor
    public Event() {}

    // Parameterized constructor
    public Event(Integer eventId, String eventName, Float eventFee) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventFee = eventFee;
    }

    // Getters and Setters
    public Integer getEventId() { return eventId; }
    public void setEventId(Integer eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public Float getEventFee() { return eventFee; }
    public void setEventFee(Float eventFee) { this.eventFee = eventFee; }
}