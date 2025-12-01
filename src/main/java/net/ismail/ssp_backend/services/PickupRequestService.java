package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.entities.PickupRequest;

import java.util.List;

public interface PickupRequestService {
    PickupRequest createRequest(Long parentId, Long studentId);
    List<PickupRequest> getRequestsByGate(Long gateId);
}

