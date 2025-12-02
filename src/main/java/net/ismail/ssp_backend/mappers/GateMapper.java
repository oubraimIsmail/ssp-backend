package net.ismail.ssp_backend.mappers;

import net.ismail.ssp_backend.dtos.GateDTO;
import net.ismail.ssp_backend.entities.Gate;
import org.springframework.stereotype.Service;

@Service
public class GateMapper {

    public GateDTO toDTO(Gate gate) {
        if (gate == null) return null;

        GateDTO dto = new GateDTO();
        dto.setId(gate.getId());
        dto.setGateName(gate.getGateName());
        dto.setLocation(gate.getLocation());

        return dto;
    }

    public Gate toEntity(GateDTO dto) {
        if (dto == null) return null;

        Gate gate = new Gate();
        gate.setId(dto.getId());
        gate.setGateName(dto.getGateName());
        gate.setLocation(dto.getLocation());

        return gate;
    }
}

