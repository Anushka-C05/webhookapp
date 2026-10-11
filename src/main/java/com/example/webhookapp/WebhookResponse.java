package com.example.webhookapp;

public class WebhookResponse {

    private String message;
    private String event;
    private String repository;
    private String user;

    public WebhookResponse(String message, String event, String repository, String user) {
        this.message = message;
        this.event = event;
        this.repository = repository;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String getEvent() {
        return event;
    }

    public String getRepository() {
        return repository;
    }

    public String getUser() {
        return user;
    }
}