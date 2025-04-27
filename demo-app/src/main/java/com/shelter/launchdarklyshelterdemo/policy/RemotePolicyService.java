package com.shelter.launchdarklyshelterdemo;

public class RemotePolicyService implements PolicyService {

    private final WebClient WebClient;

    public RemotePolicyService(WebClient WebClient) {
        this.webClient = webClient;
    }
}
