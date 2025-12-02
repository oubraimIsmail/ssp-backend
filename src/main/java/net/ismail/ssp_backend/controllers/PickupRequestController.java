package net.ismail.ssp_backend.controllers;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.PickupRequestDTO;
import net.ismail.ssp_backend.services.PickupRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class PickupRequestController {

    private final PickupRequestService requestService;

    // Parent appelle son enfant
    @PostMapping("/{parentId}/{studentId}")
    public PickupRequestDTO createRequest(
            @PathVariable Long parentId,
            @PathVariable Long studentId) {

        return requestService.createRequest(parentId, studentId);
    }

    // La TV récupère toutes les demandes de son gate
    @GetMapping("/gate/{gateId}")
    public List<PickupRequestDTO> getRequestsByGate(@PathVariable Long gateId) {
        return requestService.getRequestsByGate(gateId);
    }
}
