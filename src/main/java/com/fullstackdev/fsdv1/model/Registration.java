package com.fullstackdev.fsdv1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrationId")
    private Integer registrationId;

    @Column(name = "name")
    private String name;

    @Column(name = "college")
    private String college;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contact")
    private String contact;

    @Column(name = "password")
    private String password;

    // Default constructor
    public Registration() {}

    // Parameterized constructor
    public Registration(Integer registrationId, String name, String college, String email, String contact, String password) {
        this.registrationId = registrationId;
        this.name = name;
        this.college = college;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    // Getters and Setters
    public Integer getRegistrationId() { return registrationId; }
    public void setRegistrationId(Integer registrationId) { this.registrationId = registrationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}