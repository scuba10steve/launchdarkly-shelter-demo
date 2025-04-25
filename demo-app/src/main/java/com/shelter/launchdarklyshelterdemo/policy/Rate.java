package com.shelter.launchdarklyshelterdemo.policy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int length;

    private float amount;

    protected Rate() {}

    public Rate(int length, float amount) {
        this.length = length;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public float getAmount() {
        return amount;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}