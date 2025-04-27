package com.shelter.launchdarklyshelterdemo.policy;

import com.shelter.launchdarklyshelterdemo.feature.FeatureService;

import java.util.UUID;

public class LocalPolicyService implements PolicyService {
    private final FeatureService featureService;
    private final PolicyRepository policyRepository;
    private final RateRepository rateRepository;

    LocalPolicyService(FeatureService featureService,
                       PolicyRepository policyRepository,
                       RateRepository rateRepository) {
        this.featureService = featureService;
        this.policyRepository = policyRepository;
        this.rateRepository = rateRepository;
    }

    @Override
    public Iterable<Policy> findAll() {
        return this.policyRepository.findAll();
    }

    @Override
    public Policy findById(UUID id) {
        return this.policyRepository.findById(id).orElseThrow(() -> new PolicyNotFoundException(id));
    }

    @Override
    public Policy rateAndSave(UUID id) {
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
