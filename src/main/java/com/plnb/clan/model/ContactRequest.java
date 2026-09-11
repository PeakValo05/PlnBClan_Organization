package com.plnb.clan.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entity representing a contact request submitted through the contact form
// Maps to the "contact_requests" table in the database
@Entity
@Table(name = "contact_requests")
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String robloxUsername;

    private String discordUsername;

    private String inquiryType;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime dateSubmitted;

    private String status;

    public ContactRequest() {
        this.dateSubmitted = LocalDateTime.now();
        this.status = "NEW";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRobloxUsername() {
        return robloxUsername;
    }

    public void setRobloxUsername(String robloxUsername) {
        this.robloxUsername = robloxUsername;
    }

    public String getDiscordUsername() {
        return discordUsername;
    }

    public void setDiscordUsername(String discordUsername) {
        this.discordUsername = discordUsername;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDateTime dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}