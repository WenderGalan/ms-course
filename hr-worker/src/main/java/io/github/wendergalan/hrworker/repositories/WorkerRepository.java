package io.github.wendergalan.hrworker.repositories;

import io.github.wendergalan.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
