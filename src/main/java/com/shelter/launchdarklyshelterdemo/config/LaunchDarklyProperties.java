package com.shelter.launchdarklyshelterdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.shelter.launchdarkly")
public class LaunchDarklyProperties {
    private final String sdkKey;

    private final boolean enabled;

    public LaunchDarklyProperties(String sdkKey, boolean enabled) {
        this.sdkKey = sdkKey;
        this.enabled = enabled;
    }

    public String getSdkKey() {
        return sdkKey;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
