package com.shelter.launchdarklyshelterdemo.policy;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PolicyRepository extends CrudRepository<Policy, UUID> {}
