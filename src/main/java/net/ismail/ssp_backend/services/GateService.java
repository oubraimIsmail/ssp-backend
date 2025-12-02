package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.dtos.GateDTO;

import java.util.List;

public interface GateService {
    GateDTO createGate(GateDTO gateDTO);
    void deleteGate(Long id);
    List<GateDTO> getAllGates();
}
