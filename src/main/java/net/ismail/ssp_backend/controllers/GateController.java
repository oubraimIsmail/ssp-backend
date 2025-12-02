package net.ismail.ssp_backend.controllers;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.GateDTO;
import net.ismail.ssp_backend.services.GateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gates")
@RequiredArgsConstructor
public class GateController {

    private final GateService gateService;

    @PostMapping
    public GateDTO createGate(@RequestBody GateDTO gateDTO) {
        return gateService.createGate(gateDTO);
    }

    @DeleteMapping("{id}")
    public void deleteGate(@PathVariable Long id){
        gateService.deleteGate(id);
    }

    @GetMapping
    public List<GateDTO> getAllGates() {
        return gateService.getAllGates();
    }
}
