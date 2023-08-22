package com.shelter.launchdarklyshelterdemo.policy;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/policies")
class PolicyController {

    private final FakePolicyService policyService;

    PolicyController(FakePolicyService policyService) {
        this.policyService = policyService;
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
    Policy rateAndSave(@PathVariable String id) {
        return this.policyService.rateAndSave(UUID.fromString(id));
    }
}
