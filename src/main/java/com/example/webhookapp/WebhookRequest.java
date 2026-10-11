package com.example.webhookapp;

import jakarta.validation.constraints.NotBlank;

public class WebhookRequest {

    @NotBlank(message = "Event is required")
    private String event;

    @NotBlank(message = "Repository is required")
    private String repository;

    @NotBlank(message = "User is required")
    private String user;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}