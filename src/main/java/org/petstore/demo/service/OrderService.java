package org.petstore.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RestClient orderRestClient;

    public void delete(Long id) {
        orderRestClient.delete()
                .uri("/api/v1/orders/{id}", id)
                .retrieve().toBodilessEntity();
    }
}
