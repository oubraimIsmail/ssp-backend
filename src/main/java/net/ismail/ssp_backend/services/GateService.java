package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.entities.Gate;

import java.util.List;

public interface GateService {
    Gate createGate(Gate gate);
    List<Gate> getAllGates();
}

