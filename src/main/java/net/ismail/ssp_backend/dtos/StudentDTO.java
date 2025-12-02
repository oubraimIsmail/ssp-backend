package net.ismail.ssp_backend.dtos;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private String className;
    private Long parentId;
    private Long gateId;
}

