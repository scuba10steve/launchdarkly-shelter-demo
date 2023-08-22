package com.shelter.launchdarklyshelterdemo.policy;

import com.shelter.launchdarklyshelterdemo.feature.FeatureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
    @Bean
    FakePolicyService fakePolicyService(FeatureService featureService,
                                        PolicyRepository policyRepository,
                                        RateRepository rateRepository) {
        return new FakePolicyService(featureService, policyRepository, rateRepository);
    }
}
