package com.shelter.launchdarklyshelterdemo.feature;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.DisposableBean;

public class FeatureService implements DisposableBean {
    private final LDClient ldClient;

    public FeatureService(LDClient ldClient) {
        this.ldClient = ldClient;
    }

    public boolean useNewRates(String username, String client) {
        LDContext context = LDContext.builder(username)
                .kind("user")
                .set("name", client)
                .build();

        return this.ldClient.boolVariation("new-ppa-rate-string", context, false);
    }

    @Override
    public void destroy() throws Exception {
        this.ldClient.close();
    }
}
