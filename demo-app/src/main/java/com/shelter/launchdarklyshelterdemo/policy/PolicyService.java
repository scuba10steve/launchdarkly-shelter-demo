package com.shelter.launchdarklyshelterdemo.policy;

import java.util.UUID;

public interface PolicyService {
    Iterable<Policy> findAll();

    Policy findById(UUID id);

    Policy rateAndSave(UUID id);
}
