package com.fullstackdev.fsdv1.controller;

import com.fullstackdev.fsdv1.model.Participant;
import com.fullstackdev.fsdv1.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class ParticipantController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Integer id) {
        Optional<Participant> participant = participantRepository.findById(id);
        return participant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantRepository.save(participant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Integer id, @RequestBody Participant participantDetails) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            Participant participant = optionalParticipant.get();
            participant.setRegistrationId(participantDetails.getRegistrationId());
            participant.setEventId(participantDetails.getEventId());
            participant.setEventAmount(participantDetails.getEventAmount());
            return ResponseEntity.ok(participantRepository.save(participant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Participant> partialUpdateParticipant(@PathVariable Integer id, @RequestBody Participant participantDetails) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            Participant participant = optionalParticipant.get();
            if (participantDetails.getRegistrationId() != null) {
                participant.setRegistrationId(participantDetails.getRegistrationId());
            }
            if (participantDetails.getEventId() != null) {
                participant.setEventId(participantDetails.getEventId());
            }
            if (participantDetails.getEventAmount() != null) {
                participant.setEventAmount(participantDetails.getEventAmount());
            }
            return ResponseEntity.ok(participantRepository.save(participant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Integer id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) {
            participantRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{registrationId}")
    public List<Participant> getParticipantEvents(@PathVariable Integer registrationId) {
        return participantRepository.findByRegistrationId(registrationId);
    }
}