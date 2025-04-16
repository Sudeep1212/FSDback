package com.fullstackdev.fsdv1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participantId")
    private Integer participantId;

    @Column(name = "registrationId")
    private Integer registrationId;

    @Column(name = "eventId")
    private Integer eventId;

    @Column(name = "eventAmount")
    private Float eventAmount;

    // Foreign key relationships
    @ManyToOne
    @JoinColumn(name = "registrationId", insertable = false, updatable = false)
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "eventId", insertable = false, updatable = false)
    private Event event;

    // Default constructor
    public Participant() {}

    // Parameterized constructor
    public Participant(Integer participantId, Integer registrationId, Integer eventId, Float eventAmount) {
        this.participantId = participantId;
        this.registrationId = registrationId;
        this.eventId = eventId;
        this.eventAmount = eventAmount;
    }

    // Getters and Setters
    public Integer getParticipantId() { return participantId; }
    public void setParticipantId(Integer participantId) { this.participantId = participantId; }

    public Integer getRegistrationId() { return registrationId; }
    public void setRegistrationId(Integer registrationId) { this.registrationId = registrationId; }

    public Integer getEventId() { return eventId; }
    public void setEventId(Integer eventId) { this.eventId = eventId; }

    public Float getEventAmount() { return eventAmount; }
    public void setEventAmount(Float eventAmount) { this.eventAmount = eventAmount; }

    public Registration getRegistration() { return registration; }
    public void setRegistration(Registration registration) { this.registration = registration; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}