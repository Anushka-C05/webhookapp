package com.example.webhookapp;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final WebhookEventRepository webhookEventRepository;

    public WebhookController(WebhookEventRepository webhookEventRepository) {
        this.webhookEventRepository = webhookEventRepository;
    }

    @PostMapping("/webhook")
    public WebhookResponse receiveWebhook(@Valid @RequestBody WebhookRequest request) {

        System.out.println("Webhook received:");
        System.out.println("Event: " + request.getEvent());
        System.out.println("Repository: " + request.getRepository());
        System.out.println("User: " + request.getUser());

        WebhookEvent webhookEvent = new WebhookEvent(
                request.getEvent(),
                request.getRepository(),
                request.getUser()
        );

        webhookEventRepository.save(webhookEvent);

        return new WebhookResponse(
                "Webhook received successfully",
                request.getEvent(),
                request.getRepository(),
                request.getUser()
        );
    }

    @GetMapping("/webhook/events")
    public List<WebhookEvent> getAllEvents(
            @RequestParam(required = false) String repository) {

        if (repository != null && !repository.isBlank()) {
            return webhookEventRepository.findByRepository(repository);
        }

        return webhookEventRepository.findAll();
    }
}