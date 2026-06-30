package org.petstore.demo.config;

import lombok.RequiredArgsConstructor;
import org.petstore.demo.exception.BadGateway;
import org.petstore.demo.exception.ResourceNotFound;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

@Configuration
@RequiredArgsConstructor
public class RestConfig {

    private final ApiProperties apiProperties;

    @Bean
    public RestClient orderRestClient(RestClient.Builder builder) {
        return createClient(builder, "order", apiProperties.order());
    }

    @Bean
    public RestClient petRestClient(RestClient.Builder builder) {
        return createClient(builder, "pet", apiProperties.pet());
    }

    private RestClient createClient(RestClient.Builder builder, String serviceName, ApiProperties.ServiceConfig config) {
        return builder
                .clone() // Prevents cross-contamination between configurations
                .baseUrl(config.host())
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (req, res) -> {
                    throw new ResourceNotFound(serviceName + " resource not found");
                })
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (req, res) -> {
                    throw new BadGateway(serviceName + " gateway returned unknown error");
                })
                .build();
    }
}
