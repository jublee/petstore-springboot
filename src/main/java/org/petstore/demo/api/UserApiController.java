package org.petstore.demo.api;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.petstore.demo.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserApiController implements UserApi{
    @Override
    public ResponseEntity<User> createUser(@Nullable User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> createUsersWithListInput(@Nullable List<@Valid User> user) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(String username) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByName(String username) {
        return null;
    }

    @Override
    public ResponseEntity<String> loginUser(@Nullable String username, @Nullable String password) {
        return null;
    }

    @Override
    public ResponseEntity<Void> logoutUser() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateUser(String username, @Nullable User user) {
        return null;
    }
}
