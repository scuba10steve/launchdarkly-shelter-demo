package com.shelter.launchdarklyshelterdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.shelter.launchdarklydemo")
public class LaunchDarklyProperties {
    private final String sdkKey;

    public LaunchDarklyProperties(String sdkKey) {
        this.sdkKey = sdkKey;
    }

    public String getSdkKey() {
        return sdkKey;
    }
}
