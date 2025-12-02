package net.ismail.ssp_backend.dtos;

import lombok.Data;
import net.ismail.ssp_backend.enums.Role;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private Role role;
}

