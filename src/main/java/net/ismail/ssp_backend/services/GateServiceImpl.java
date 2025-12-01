package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.repositories.GateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GateServiceImpl implements GateService {

    private final GateRepository gateRepository;

    @Override
    public Gate createGate(Gate gate) {
        return gateRepository.save(gate);
    }

    @Override
    public List<Gate> getAllGates() {
        return gateRepository.findAll();
    }
}

