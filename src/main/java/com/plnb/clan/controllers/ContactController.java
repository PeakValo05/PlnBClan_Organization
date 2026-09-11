package com.plnb.clan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.plnb.clan.model.ContactRequest;
import com.plnb.clan.repository.ContactRequestRepository;
import com.plnb.clan.service.DiscordWebhookService;

// Controller for handling contact form submissions
@Controller
public class ContactController {

    private final DiscordWebhookService discordWebhookService;
    private final ContactRequestRepository contactRequestRepository;

    public ContactController(ContactRequestRepository contactRequestRepository, DiscordWebhookService discordWebhookService) {
        this.contactRequestRepository = contactRequestRepository;
        this.discordWebhookService = discordWebhookService;
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

        discordWebhookService.sendMessage(
                contactRequest.getRobloxUsername(),
                contactRequest.getDiscordUsername(),
                contactRequest.getInquiryType(),
                contactRequest.getMessage()
        );

        return "redirect:/?success";
    }
}