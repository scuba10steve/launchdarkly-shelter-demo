package com.shelter.launchdarklyshelterdemo.policy;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String client;

    @OneToOne
    private Rate rate;

    public Policy() {}

    public Policy(String name) {
        this.id = UUID.randomUUID();
        this.client = name;
    }

    public UUID getId() {
        return id;
    }

    void setId(UUID id) {
        this.id = id;
    }

    public Rate getRate() {
        return rate;
    }

    void setRate(Rate rate) {
        this.rate = rate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
