package org.petstore.demo.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.petstore.demo.api.model.ModelApiResponse;
import org.petstore.demo.api.model.Pet;
import org.petstore.demo.service.PetService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PetApiController implements PetApi {

    private final PetService petService;

    @Override
    public ResponseEntity<Pet> addPet(Pet pet) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, @Nullable String apiKey) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(String status) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByTags(List<String> tags) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        log.info("getPetById {}", petId);
        return ResponseEntity.ok(petService.getPet(petId));
    }

    @Override
    public ResponseEntity<Pet> updatePet(Pet pet) {
        return null;
    }

    @Override
    public ResponseEntity<Pet> updatePetWithForm(Long petId, @Nullable String name, @Nullable String status) {
        return null;
    }

    @Override
    public ResponseEntity<ModelApiResponse> uploadFile(Long petId, @Nullable String additionalMetadata, @Nullable Resource body) {
        return null;
    }
}
