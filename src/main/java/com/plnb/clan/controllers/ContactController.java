package com.plnb.clan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.plnb.clan.model.ContactRequest;
import com.plnb.clan.repository.ContactRequestRepository;

@Controller
public class ContactController {

    private final ContactRequestRepository contactRequestRepository;

    public ContactController(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    // Display the contact form on the home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("contactRequest", new ContactRequest());
        return "index";
    }

    // Handle the submission of the contact form
    @PostMapping("/contact/submit")
    public String submitContact(
            @ModelAttribute ContactRequest contactRequest) {

        contactRequestRepository.save(contactRequest);

        return "redirect:/?success";
    }
}