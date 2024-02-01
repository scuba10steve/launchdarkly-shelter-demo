package com.shelter.launchdarklyshelterdemo.policy;

import com.shelter.launchdarklyshelterdemo.feature.FeatureService;
import com.shelter.launchdarklyshelterdemo.policy.metrics.Instrumentation;
import io.micrometer.core.instrument.MeterRegistry;
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

    @Bean
    Instrumentation instrumentation(MeterRegistry meterRegistry) {
        return new Instrumentation(meterRegistry);
    }
}
