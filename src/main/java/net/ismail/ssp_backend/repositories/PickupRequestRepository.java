package net.ismail.ssp_backend.repositories;

import net.ismail.ssp_backend.entities.PickupRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickupRequestRepository extends JpaRepository<PickupRequest, Long> {
    List<PickupRequest> findByGateId(Long gateId);
}
