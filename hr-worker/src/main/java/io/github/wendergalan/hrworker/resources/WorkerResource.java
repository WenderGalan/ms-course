package io.github.wendergalan.hrworker.resources;

import io.github.wendergalan.hrworker.entities.Worker;
import io.github.wendergalan.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Log4j2
public class WorkerResource {
    private final WorkerRepository repository;
    private final Environment env;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        log.info("PORT = " + env.getProperty("local.server.port"));
        Optional<Worker> worker = repository.findById(id);
        return ResponseEntity.ok(worker.orElse(null));
    }
}
