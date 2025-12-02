package net.ismail.ssp_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ParentDTO {
    private Long id;
    private String name;
    private List<StudentDTO> studentDTOList;
}
