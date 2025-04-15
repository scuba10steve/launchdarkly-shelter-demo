package com.shelter.launchdarklyshelterdemo.feature;

public class DisabledFeatureService implements FeatureService {
    @Override
    public boolean useNewRates(String username, String client) {
        return false;
    }
}
