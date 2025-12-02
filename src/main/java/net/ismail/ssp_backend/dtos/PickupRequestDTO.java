package net.ismail.ssp_backend.dtos;

import lombok.Data;
import net.ismail.ssp_backend.enums.Status;

import java.util.Date;

@Data
public class PickupRequestDTO {

    private Long id;
    private Date requestTime;
    private Status status;
    private Long studentId;
    private Long gateId;
    private Long parentId;
}

