package com.shelter.launchdarklyshelterdemo.policy;

import com.shelter.launchdarklyshelterdemo.feature.FeatureService;

import java.util.UUID;

public class FakePolicyService {
    private final FeatureService featureService;
    private final PolicyRepository policyRepository;
    private final RateRepository rateRepository;

    FakePolicyService (FeatureService featureService,
                       PolicyRepository policyRepository,
                       RateRepository rateRepository) {
        this.featureService = featureService;
        this.policyRepository = policyRepository;
        this.rateRepository = rateRepository;
    }

    public Iterable<Policy> findAll() {
        return this.policyRepository.findAll();
    }

    Policy findById(UUID id) {
        return this.policyRepository.findById(id).orElseThrow(() -> new PolicyNotFoundException(id));
    }

    Policy rateAndSave(UUID id) {
        Policy policy = findById(id);

        Rate rate;
        if (featureService.useNewRates(id.toString(), policy.getClient())) {
            // As good as pie
            rate = new Rate(6, 3.14159f);
        } else {
            rate = new Rate(6, 45.99f);
        }

        rateRepository.save(rate);
        policy.setRate(rate);

        return this.policyRepository.save(policy);
    }
}
