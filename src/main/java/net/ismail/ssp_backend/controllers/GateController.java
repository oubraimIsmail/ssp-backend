package net.ismail.ssp_backend.controllers;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.services.GateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gates")
@RequiredArgsConstructor
public class GateController {

    private final GateService gateService;

    @PostMapping
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.createGate(gate);
    }

    @GetMapping
    public List<Gate> getAllGates() {
        return gateService.getAllGates();
    }
}

