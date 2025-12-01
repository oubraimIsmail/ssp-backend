package net.ismail.ssp_backend.repositories;

import net.ismail.ssp_backend.entities.Gate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateRepository extends JpaRepository<Gate, Long> {
}
