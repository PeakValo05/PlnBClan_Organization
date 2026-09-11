package com.plnb.clan.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DiscordWebhookService {

    @Value("${discord.webhook.url}")
    private String webhookUrl;

    private final RestClient restClient = RestClient.create();

    public void sendMessage(
            String robloxUsername,
            String discordUsername,
            String inquiryType,
            String message) {

        String content =
                "**📩 New plnB Contact Request**\n\n" +
                "**Roblox Username:** " + robloxUsername + "\n" +
                "**Discord Username:** " + discordUsername + "\n" +
                "**Inquiry Type:** " + inquiryType + "\n\n" +
                "**Message:**\n" + message;

        DiscordMessage payload = new DiscordMessage(content);

        restClient.post()
                .uri(webhookUrl)
                .body(payload)
                .retrieve()
                .toBodilessEntity();
    }

    private record DiscordMessage(String content) {}
}