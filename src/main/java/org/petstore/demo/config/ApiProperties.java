package org.petstore.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "endpoints")
public record ApiProperties(ServiceConfig order, ServiceConfig pet) {
    public record ServiceConfig(String host, int timeoutSeconds) {
    }
}