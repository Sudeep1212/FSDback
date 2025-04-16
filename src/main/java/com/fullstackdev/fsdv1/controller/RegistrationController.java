package com.fullstackdev.fsdv1.controller;

import com.fullstackdev.fsdv1.model.LoginRequest;
import com.fullstackdev.fsdv1.model.Registration;
import com.fullstackdev.fsdv1.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Integer id) {
        Optional<Registration> registration = registrationRepository.findById(id);
        return registration.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Registration createRegistration(@RequestBody Registration registration) {
        return registrationRepository.save(registration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Integer id, @RequestBody Registration registrationDetails) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(id);
        if (optionalRegistration.isPresent()) {
            Registration registration = optionalRegistration.get();
            registration.setName(registrationDetails.getName());
            registration.setCollege(registrationDetails.getCollege());
            registration.setEmail(registrationDetails.getEmail());
            registration.setContact(registrationDetails.getContact());
            registration.setPassword(registrationDetails.getPassword());
            return ResponseEntity.ok(registrationRepository.save(registration));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Registration> partialUpdateRegistration(@PathVariable Integer id, @RequestBody Registration registrationDetails) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(id);
        if (optionalRegistration.isPresent()) {
            Registration registration = optionalRegistration.get();
            if (registrationDetails.getName() != null) {
                registration.setName(registrationDetails.getName());
            }
            if (registrationDetails.getCollege() != null) {
                registration.setCollege(registrationDetails.getCollege());
            }
            if (registrationDetails.getEmail() != null) {
                registration.setEmail(registrationDetails.getEmail());
            }
            if (registrationDetails.getContact() != null) {
                registration.setContact(registrationDetails.getContact());
            }
            if (registrationDetails.getPassword() != null) {
                registration.setPassword(registrationDetails.getPassword());
            }
            return ResponseEntity.ok(registrationRepository.save(registration));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Integer id) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(id);
        if (optionalRegistration.isPresent()) {
            registrationRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Registration> login(@RequestBody LoginRequest loginRequest) {
        Optional<Registration> registration = registrationRepository.findByEmail(loginRequest.getEmail());
        if (registration.isPresent() && registration.get().getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(registration.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Registration> getRegistrationByEmail(@PathVariable String email) {
        Optional<Registration> registration = registrationRepository.findByEmail(email);
        return registration.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}