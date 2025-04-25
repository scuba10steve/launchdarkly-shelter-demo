package com.shelter.launchdarklyshelterdemo.policy;

import java.util.UUID;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(UUID id) {
        super("Policy with id: '%s' not found!".formatted(id.toString()));
    }
}
