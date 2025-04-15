package com.shelter.launchdarklyshelterdemo.config;

import com.launchdarkly.sdk.server.LDClient;
import com.shelter.launchdarklyshelterdemo.feature.FeatureService;
import com.shelter.launchdarklyshelterdemo.feature.LDFeatureService;
import com.shelter.launchdarklyshelterdemo.feature.DisabledFeatureService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {LaunchDarklyProperties.class})
public class LaunchDarklyConfig {

    @Bean
    @ConditionalOnProperty(prefix = "com.shelter.launchdarkly", value = "enabled", havingValue = "true", matchIfMissing = true)
    FeatureService ldFeatureService(LDClient ldClient) {
        return new LDFeatureService(ldClient);
    }

    @Bean
    @ConditionalOnProperty(prefix = "com.shelter.launchdarkly", value = "enabled", havingValue = "false", matchIfMissing = false)
    FeatureService localFeatureService() {
        return new DisabledFeatureService();
    }

    @Bean
    LDClient ldClient(LaunchDarklyProperties launchDarklyProperties) {
        return new LDClient(launchDarklyProperties.getSdkKey());
    }
}
