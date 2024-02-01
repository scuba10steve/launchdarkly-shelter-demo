package com.shelter.launchdarklyshelterdemo.policy.metrics;

import com.shelter.launchdarklyshelterdemo.policy.Policy;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;

import java.util.concurrent.Callable;

public class Instrumentation {

    private final MeterRegistry registry;

    public Instrumentation(MeterRegistry registry) {
        this.registry = registry;
    }

    public Policy instrument(Callable<Policy> callable, String policyId) throws Exception {
        return Timer.builder("shelter.demo.rating.duration")
                .tags(Tags.of("policyId", policyId))
                .register(registry)
                .recordCallable(callable);
    }
}
