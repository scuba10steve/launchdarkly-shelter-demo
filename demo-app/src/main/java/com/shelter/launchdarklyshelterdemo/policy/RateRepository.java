package com.shelter.launchdarklyshelterdemo.policy;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RateRepository extends CrudRepository<Rate, UUID> {
}
