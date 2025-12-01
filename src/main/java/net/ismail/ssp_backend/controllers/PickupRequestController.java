package net.ismail.ssp_backend.controllers;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.entities.PickupRequest;
import net.ismail.ssp_backend.services.PickupRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class PickupRequestController {

    private final PickupRequestService requestService;

    // Le parent appelle son enfant
    @PostMapping("/{parentId}/{studentId}")
    public PickupRequest createRequest(@PathVariable Long parentId, @PathVariable Long studentId) {

        return requestService.createRequest(parentId, studentId);
    }

    // L'écran TV récupère toutes les demandes pour son gate
    @GetMapping("/gate/{gateId}")
    public List<PickupRequest> getRequestsByGate(
            @PathVariable Long gateId) {

        return requestService.getRequestsByGate(gateId);
    }
}

