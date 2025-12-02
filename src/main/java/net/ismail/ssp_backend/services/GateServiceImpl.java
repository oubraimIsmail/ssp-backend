package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.GateDTO;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.mappers.GateMapper;
import net.ismail.ssp_backend.repositories.GateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GateServiceImpl implements GateService {

    private final GateRepository gateRepository;
    private final GateMapper gateMapper;

    @Override
    public GateDTO createGate(GateDTO gateDTO) {
        Gate gate = gateMapper.toEntity(gateDTO);
        Gate saved = gateRepository.save(gate);
        return gateMapper.toDTO(saved);
    }

    @Override
    public void deleteGate(Long id) {
        if (!gateRepository.existsById(id)) {
            throw new RuntimeException("gate not found");
        }
        gateRepository.deleteById(id);
    }

    @Override
    public List<GateDTO> getAllGates() {
        return gateRepository.findAll()
                .stream()
                .map(gateMapper::toDTO)
                .collect(Collectors.toList());
    }
}
