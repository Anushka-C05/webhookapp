package com.example.webhookapp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookEventRepository
        extends JpaRepository<WebhookEvent, Long> {

    List<WebhookEvent> findByRepository(String repository);
}