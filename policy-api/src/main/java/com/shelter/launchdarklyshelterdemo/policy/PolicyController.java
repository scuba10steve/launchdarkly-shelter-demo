package com.shelter.launchdarklyshelterdemo.policy;

import com.shelter.launchdarklyshelterdemo.policy.metrics.Instrumentation;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/policies")
class PolicyController {

    private final LocalPolicyService policyService;
    private final Instrumentation instrumentation;

    PolicyController(LocalPolicyService policyService,
                     Instrumentation instrumentation) {
        this.policyService = policyService;
        this.instrumentation = instrumentation;
    }

    @GetMapping
    Iterable<Policy> findAll() {
        return this.policyService.findAll();
    }

    @GetMapping("/{id}")
    Policy findById(@PathVariable String id) {
        return this.policyService.findById(UUID.fromString(id));
    }

    @PutMapping("/{id}/rate")
    Policy rateAndSave(@PathVariable String id) throws Exception {
        return instrumentation.instrument(() -> this.policyService.rateAndSave(UUID.fromString(id)), id);
    }
}
