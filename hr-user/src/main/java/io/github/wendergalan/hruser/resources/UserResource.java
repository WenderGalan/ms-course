package io.github.wendergalan.hruser.resources;

import io.github.wendergalan.hruser.entities.User;
import io.github.wendergalan.hruser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@Log4j2
@RefreshScope
public class UserResource {
    private final UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return ResponseEntity.ok(user.orElse(null));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(repository.findByEmail(email));
    }
}