package com.shelter.launchdarklyshelterdemo.config;

import com.launchdarkly.sdk.server.LDClient;
import com.shelter.launchdarklyshelterdemo.feature.FeatureService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {LaunchDarklyProperties.class})
public class LaunchDarklyConfig {

    @Bean
    FeatureService featureService(LDClient ldClient) {
        return new FeatureService(ldClient);
    }

    @Bean
    LDClient ldClient(LaunchDarklyProperties launchDarklyProperties) {
        return new LDClient(launchDarklyProperties.getSdkKey());
    }
}
