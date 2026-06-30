package org.petstore.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.petstore.demo.api.model.Pet;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetService {

    private final RestClient petRestClient;

    public Pet getPet(Long id) {
        return petRestClient.get()
                .uri("/api/v1/pets/{id}", id)
                .retrieve()
                .toEntity(Pet.class)
                .getBody();
    }
}
