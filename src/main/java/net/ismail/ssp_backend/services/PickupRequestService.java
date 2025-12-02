package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.dtos.PickupRequestDTO;

import java.util.List;

public interface PickupRequestService {

    PickupRequestDTO createRequest(Long parentId, Long studentId);
    List<PickupRequestDTO> getRequestsByGate(Long gateId);
}
