package net.ismail.ssp_backend.mappers;

import net.ismail.ssp_backend.dtos.PickupRequestDTO;
import net.ismail.ssp_backend.entities.PickupRequest;
import org.springframework.stereotype.Service;

@Service
public class PickupRequestMapper {

    public PickupRequestDTO toDTO(PickupRequest p) {
        if (p == null) return null;

        PickupRequestDTO dto = new PickupRequestDTO();
        dto.setId(p.getId());
        dto.setRequestTime(p.getRequestTime());
        dto.setStatus(p.getStatus());

        dto.setStudentId(
                p.getStudent() != null ? p.getStudent().getId() : null
        );
        dto.setGateId(
                p.getGate() != null ? p.getGate().getId() : null
        );
        dto.setParentId(
                p.getParent() != null ? p.getParent().getId() : null
        );

        return dto;
    }

    public PickupRequest toEntity(PickupRequestDTO dto) {
        if (dto == null) return null;

        PickupRequest p = new PickupRequest();
        p.setId(dto.getId());
        p.setRequestTime(dto.getRequestTime());

        if (dto.getStatus() != null)
            p.setStatus(dto.getStatus());

        return p;
    }
}

