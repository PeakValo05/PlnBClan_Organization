package com.plnb.clan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plnb.clan.model.ContactRequest;

// Repository interface for managing ContactRequest entities
public interface ContactRequestRepository
        extends JpaRepository<ContactRequest, Long> {
}